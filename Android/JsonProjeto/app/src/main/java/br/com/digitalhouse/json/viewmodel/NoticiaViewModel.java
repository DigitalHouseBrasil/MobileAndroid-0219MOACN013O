package br.com.digitalhouse.json.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.json.model.Noticia;
import br.com.digitalhouse.json.model.NoticiaResposta;
import br.com.digitalhouse.json.repository.NoticiaRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NoticiaViewModel extends AndroidViewModel {
    private MutableLiveData<List<Noticia>> listaNoticia = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private NoticiaRepository repository = new NoticiaRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public NoticiaViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Noticia>> retornaNoticas() {
        return this.listaNoticia;
    }

    public LiveData<Boolean> retornaValorLoading() {
        return this.loading;
    }

    public void buscaNoticias() {
        disposable.add(
                //Chama o método a partir do repository
                repository.obterListaNoticias(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //O doOnSubscribe realiza uma ação enquanto o observable está emitindo dados
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        //O doOnAfterTerminate realiza uma ação logo após o observable termina a emissao de dados
                        .doAfterTerminate(() -> loading.setValue(false))
                        .subscribe(noticiaResposta -> listaNoticia.setValue(noticiaResposta.getNoticias()),
                                throwable -> {
                                    Log.i("LOG", "busca noticias" + throwable.getMessage());
                                })

        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

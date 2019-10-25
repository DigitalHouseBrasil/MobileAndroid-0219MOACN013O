package br.com.digitalhouse.appmytasks.viewmodel;

import android.app.Application;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.appmytasks.model.data.Database;
import br.com.digitalhouse.appmytasks.model.data.TarefaDao;
import br.com.digitalhouse.appmytasks.model.pojos.Tarefa;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends AndroidViewModel {
    ///Atributo do tipo MutableLiveDate, lembrando que esse tipo de dado permite leitura e escrita de dados
    private MutableLiveData<List<Tarefa>> listaTarefas = new MutableLiveData<>();

    //Inicialização do dao
    private TarefaDao tarefaDao = Database.getDatabase(getApplication()).tarefaDao();

    /*Inicialização do disposable
    Sempre que estiver realizando vários subcriptions, podemos utilizar a classe CompositeDisposable
    e adicionamos os objetos a ele com isso ele libera recursos e threads alocados para o observer
    por meio do disposable através do método disposable.clear()
     */
    private CompositeDisposable disposable = new CompositeDisposable();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Tarefa>> retornaListaTarefas() {
        return this.listaTarefas;
    }

    public void buscaTarefasRecentes() {
        disposable.add(
                tarefaDao.tarefasRecentes()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(tarefas -> {
                                    listaTarefas.setValue(tarefas);
                                },
                                throwable -> {
                                    Log.i("LOG", "Tarefas recentes " + throwable.getMessage());
                                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

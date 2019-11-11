package br.com.digitalhouse.firebaseapp.home.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.firebaseapp.model.Result;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.firebaseapp.network.RetrofitService.API_KEY;
import static br.com.digitalhouse.firebaseapp.network.RetrofitService.getApiService;

public class HomeViewModel extends AndroidViewModel {
    public MutableLiveData<List<Result>> filmesLiveData = new MutableLiveData<>();
    public MutableLiveData<Result> favoriteAdded = new MutableLiveData<>();
    public MutableLiveData<Throwable> resultLiveDataError = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void buscarFilmes() {

        disposable.add(
                getApiService().buscarFilmes(API_KEY, "PT-BR")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe((Disposable disposable) -> isLoading.setValue(true))
                        .doOnTerminate(() -> isLoading.setValue(false))
                        .subscribe(movieResponse ->
                                {
                                    filmesLiveData.setValue(movieResponse.getResults());
                                }
                                , throwable -> {
                                    //Se deu algum erro na requisição mostramos a mensagem de erro e carregamos o dados da base de dados
                                    resultLiveDataError.setValue(throwable);
                                })
        );
    }

    // TODO: Salvar filme no firebase database
    public void salvarFavorito(Result result) {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

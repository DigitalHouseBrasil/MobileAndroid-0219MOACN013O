package br.com.digitalhouse.mercadolivreapp.digitalhouse.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.data.database.DatabaseRoom;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.data.database.ResultsDao;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.MercadoLivreResponse;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Result;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.repository.MercadoLivreRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static br.com.digitalhouse.mercadolivreapp.digitalhouse.util.AppUtil.isNetworkConnected;

public class MercadoLivreViewModel extends AndroidViewModel {
    //Atributo que é uma lista de Result
    private MutableLiveData<List<Result>> resultLiveData = new MutableLiveData<>();
    //Atributo do tipo Boolean
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    //Declaração do disposable
    private CompositeDisposable disposable = new CompositeDisposable();
    //Declaração do repository
    private MercadoLivreRepository repository = new MercadoLivreRepository();


    public MercadoLivreViewModel(@NonNull Application application) {
        super(application);
    }

    //Méetodo que retorna o valor da lista de Results em um LiveDate que irá observar as modificações dos
    //dados da lista
    public LiveData<List<Result>> getResultLiveData() {
        return resultLiveData;
    }

    //Méetodo que retorna o valor da lista de Results em um LiveDate que irá observar as modificações dos
    //dados da lista
    public LiveData<Boolean> getLoading() {
        return loading;
    }

    /**
     * Método publico que irá queeber um item a ser pesquisado, esse método também chama o método
     * estático isNetworkConnected que verifica se existe conexão com a internet.
     * Se houver conexão com a internet ele chama o método getFromNetwork que traz os dados da API
     * Senão ele traz os dados do banco de dados local
     */
    public void searchItem(String item) {
        if (isNetworkConnected(getApplication())) {
            getFromNetwork(item);
        } else {
            getFromLocal();
        }
    }

    //Método que recupera os dados do banco de dados local
    private void getFromLocal() {
        disposable.add(
                repository.getLocalResults(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> {
                            loading.setValue(true);
                        })
                        .doAfterTerminate(() -> {
                            loading.setValue(false);
                        })
                        .subscribe(results -> {
                            resultLiveData.setValue(results);
                        }, throwable -> {
                            Log.i("LOG", "getFromLocal" + throwable.getMessage());
                        })
        );

    }

    //Método que pega os dados da api e salva os dados vindo da api no banco de dados
    private void getFromNetwork(String item) {
        disposable.add(
                //através do repository chama o método que irá biscar os dados da api
                repository.searchItems(item)
                        //Determina em que thread irá acontecer o processo
                        .subscribeOn(Schedulers.newThread())
                /**o operator map transformar os itens emitidos por um Observável aplicando uma função a cada item
                 * nesse a "transformação" será os dados que estão vindo no observable serem salvos no banco de dados local
                 * através do método saveItems.
                 * Nesse caso o .map(this::saveItems) pega os dados que veio da chamada da api e passa como parametro
                 * para o proximo método implicitamente que nesse caso é o método saveItems
                 */
                        .map(this::saveItems)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(subscription -> {
                            loading.setValue(true);
                        })
                        .doAfterTerminate(() -> {
                            loading.setValue(false);
                        })
                        .subscribe(mercadoLivreResponse -> {
                            resultLiveData.setValue(mercadoLivreResponse.getResults());
                        }, throwable -> {
                            Log.i("LOG", "getFromNetwork" + throwable.getMessage());
                        })
        );
    }

    //Método que salva os items vindo da api no banco de dados local
    private MercadoLivreResponse saveItems(MercadoLivreResponse mercadoLivreResponse) {
        //Cria uma instancoa do Banco de dados
        ResultsDao dao = DatabaseRoom.getDatabase(getApplication().getApplicationContext())
                .resultsDAO();

        //Chama o método que apaga todos os dados do bd
        dao.deleteAll();
        //Chama o  método que insere novos dados no banco de dados
        dao.insert(mercadoLivreResponse.getResults());

        return mercadoLivreResponse;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

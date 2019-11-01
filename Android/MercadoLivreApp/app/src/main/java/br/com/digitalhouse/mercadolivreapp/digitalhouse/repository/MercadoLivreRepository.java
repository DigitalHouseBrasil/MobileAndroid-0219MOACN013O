package br.com.digitalhouse.mercadolivreapp.digitalhouse.repository;

import android.content.Context;

import java.util.List;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.data.database.DatabaseRoom;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.data.database.ResultsDao;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.data.network.RetrofitService;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.MercadoLivreResponse;
import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.Result;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class MercadoLivreRepository {

    // Pega os dados do banco de dados local
    public Flowable<List<Result>> getLocalResults(Context context) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDao resultsDao = room.resultsDAO();
        return resultsDao.getAll();
    }

    // Insere uma lista reults no banco de dados
    public void insertItems(Context context, List<Result> items) {
        DatabaseRoom room = DatabaseRoom.getDatabase(context);
        ResultsDao resultsDao = room.resultsDAO();
        resultsDao.insert(items);
    }

    // Pega os items que virão da api do mercado livre
    public Observable<MercadoLivreResponse> searchItems(String item) {
        return RetrofitService.getApiService().searchItem(item);
    }
}

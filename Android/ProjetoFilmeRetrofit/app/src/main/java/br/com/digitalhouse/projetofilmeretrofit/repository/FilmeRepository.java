package br.com.digitalhouse.projetofilmeretrofit.repository;

import br.com.digitalhouse.projetofilmeretrofit.model.FilmeResult;
import io.reactivex.Observable;

import static br.com.digitalhouse.projetofilmeretrofit.data.remote.RetrofitService.getApiService;

public class FilmeRepository {

    public Observable<FilmeResult> getFilmes(String apiKey, int pagina){
        return getApiService().getAllFilmes(apiKey, pagina);
    }

}

package br.com.digitalhouse.mercadolivreapp.digitalhouse.data.network;

import br.com.digitalhouse.mercadolivreapp.digitalhouse.model.MercadoLivreResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    //Método GET que apartir de uma query irá retornar os dados da api
    @GET("sites/MLA/search")
    Observable<MercadoLivreResponse> searchItem(@Query("q") String item);
}


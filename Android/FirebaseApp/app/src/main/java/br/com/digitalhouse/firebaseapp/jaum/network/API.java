package br.com.digitalhouse.firebaseapp.jaum.network;


import br.com.digitalhouse.firebaseapp.jaum.model.Movie;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    //metodo que retorna uma lista de filmes dos ultimos lancamentos
    @GET("movie/now_playing")
    Observable<Movie> buscarFilmes(
            @Query("api_key") String api_key,
            @Query("language") String language
    );
}

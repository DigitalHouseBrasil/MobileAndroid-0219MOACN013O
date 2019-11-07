package com.example.tmdbaudio.network;

import com.example.tmdbaudio.model.Artista;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    @GET("searchalbum.php")
    Observable<Artista> getAllAlbunArtist(
            @Query("s") String artista);
}

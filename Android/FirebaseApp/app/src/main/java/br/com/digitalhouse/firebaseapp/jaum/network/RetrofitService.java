package br.com.digitalhouse.firebaseapp.jaum.network;

import java.util.concurrent.TimeUnit;

import br.com.digitalhouse.firebaseapp.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "e1a9eef62eef24833db25f0491f893c7";
    private static Retrofit retrofit;

    private static Retrofit getRetrofit() {

        // Se a variavém retrofite estiver nula inicializamos
        if (retrofit == null) {

            // Configuração de parametros de conexão
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout(30, TimeUnit.SECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS);
            httpClient.writeTimeout(30, TimeUnit.SECONDS);

            // Se estivermos em modo DEBUG habilitamos os logs
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(httpLoggingInterceptor);
            }

            // inicializamos o retrofit com as configurações
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    // Retornamos a api criada com o retrofit
    public static API getApiService() {
        return getRetrofit().create(API.class);
    }
}

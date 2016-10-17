package com.example.admin.beastmovies.live;

import com.example.admin.beastmovies.infrastructure.BeastMoviesApplication;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ADMIN on 16/10/2016.
 */
public class Module {
    public static void Register(BeastMoviesApplication application){
        new LiveMovieService(application,createMovieService());
    }
    private static MovieWebServices createMovieService(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BeastMoviesApplication.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MovieWebServices.class);
    }
}

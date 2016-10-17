package com.example.admin.beastmovies.live;

import com.example.admin.beastmovies.model.ParentModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ADMIN on 17/10/2016.
 */
public interface MovieWebServices {
    @GET("/3/movie/{parameter}")
    Call<ParentModel> loadMovies(
            @Path("parameter") String requestType,
            @Query("api_key") String APIKEY
    );
}

package com.example.admin.beastmovies.live;

import com.example.admin.beastmovies.entities.Movie;
import com.example.admin.beastmovies.infrastructure.BeastMoviesApplication;
import com.example.admin.beastmovies.model.MovieModel;
import com.example.admin.beastmovies.model.ParentModel;
import com.example.admin.beastmovies.services.MovieServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ADMIN on 16/10/2016.
 */
public class LiveMovieService extends BaseLiveService {

    public LiveMovieService(BeastMoviesApplication application, MovieWebServices api) {
        super(application, api);
    }

    @Subscribe
    public void getMpvieMessage(MovieServices.SearchMoviesRequest request){
        final MovieServices.SearchMoviesResponse Movieresponse=new MovieServices.SearchMoviesResponse();
        Movieresponse.movies=new ArrayList<>();
        Call<ParentModel> call=api.loadMovies(request.query,BeastMoviesApplication.API_KEY);
        call.enqueue(new Callback<ParentModel>() {
            @Override
            public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
                for(MovieModel movieModel:response.body().movieInfos){
                    Movieresponse.movies.add(new Movie(movieModel.getMovieTitle(),movieModel.getMovieSummary(),
                            BeastMoviesApplication.BASE_PICTURE_URL+movieModel.getMoviePoster(),
                            movieModel.getMovieReleaseDate(),movieModel.getMovieAverage()));
                }
                bus.post(Movieresponse);
            }

            @Override
            public void onFailure(Call<ParentModel> call, Throwable t) {

            }
        });
    }
}

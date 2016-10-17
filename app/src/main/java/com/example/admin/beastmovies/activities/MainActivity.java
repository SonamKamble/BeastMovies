package com.example.admin.beastmovies.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.beastmovies.R;
import com.example.admin.beastmovies.entities.Movie;
import com.example.admin.beastmovies.services.MovieServices;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    ProgressBar progressBar;
    TextView movieSummary;
    TextView movieVote;
    ImageView moviePicture;
    TextView movieReleaseDate;
    TextView movieTitle;
    ImageView rightArrow;
    ImageView leftArrow;

    ArrayList<Movie> movies;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.activity_main_progressBar);
        movieSummary=(TextView)findViewById(R.id.activity_main_movie_summary);
        movieVote=(TextView)findViewById(R.id.activity_main_movie_vote);
        moviePicture=(ImageView)findViewById(R.id.activity_main_moviePicture);
        movieReleaseDate=(TextView)findViewById(R.id.activity_movieReleaseDate);
        movieTitle=(TextView)findViewById(R.id.activity_main_movieTitle);
        rightArrow=(ImageView)findViewById(R.id.activity_main_right_arrow);
        leftArrow=(ImageView)findViewById(R.id.activity_main_left_arrow);

        movies=new ArrayList<>();
        index=0;
        bus.post(new MovieServices.SearchMoviesRequest("popular"));
        if(movies.size()!=0) {
            updateUI(movies.get(index));
        }
    }

    private void updateUI(Movie movie){
        progressBar.setVisibility(View.VISIBLE);
        movieTitle.setText(movie.getMovieTitle());
        movieSummary.setText(movie.getMovieSummary());
        movieReleaseDate.setText(movie.getMovieReleaseDate());
        movieVote.setText(Double.toString(movie.getMovieRating()));
        Log.i(MainActivity.class.getSimpleName(),movie.getMoviePicture());

        Picasso.with(this).load(movie.getMoviePicture())
                .fit()
                .centerCrop()
                .into(moviePicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }


   public void onClick(View v){
        if(v==leftArrow){
            if(index==0){
                Toast.makeText(this,"This is the start of the movies!!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                index--;
                updateUI(movies.get(index));
            }
        }
       if(v==rightArrow){
           if(index==movies.size()-1){
               Toast.makeText(this,"This is the end of the movies",Toast.LENGTH_SHORT).show();
           }
           else {
               index++;
               updateUI(movies.get(index));
           }
       }
   }
   @Subscribe
    public void getMovieMessage(MovieServices.SearchMoviesResponse response){
        movies.clear();
        movies.addAll(response.movies);
    }
}

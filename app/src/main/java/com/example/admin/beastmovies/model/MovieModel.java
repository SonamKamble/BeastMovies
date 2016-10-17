package com.example.admin.beastmovies.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ADMIN on 17/10/2016.
 */
public class MovieModel {
    @SerializedName("poster_path")
    String moviePoster;

    @SerializedName("overview")
    String movieSummary;

    @SerializedName("release_date")
    String movieReleaseDate;

    @SerializedName("title")
    String movieTitle;

    @SerializedName("vote_average")
    double movieAverage;

    public MovieModel() {
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public double getMovieAverage() {
        return movieAverage;
    }
}

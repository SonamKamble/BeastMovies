package com.example.admin.beastmovies.services;

import com.example.admin.beastmovies.entities.Movie;

import java.util.ArrayList;

/**
 * Created by ADMIN on 16/10/2016.
 */
public class MovieServices {
    private MovieServices() {
    }

   public static class SearchMoviesRequest{
       public String query;

       public SearchMoviesRequest(String query) {
           this.query = query;
       }
   }
    public static class SearchMoviesResponse{
        public ArrayList<Movie> movies;
    }
}

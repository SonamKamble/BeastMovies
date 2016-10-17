package com.example.admin.beastmovies.infrastructure;

import android.app.Application;

import com.example.admin.beastmovies.live.Module;
import com.squareup.otto.Bus;

/**
 * Created by ADMIN on 16/10/2016.
 */
public class BeastMoviesApplication extends Application {
    private Bus bus;

    public static final String API_KEY="75c09f6674e885f4a6c9a55b0d94ce70";
    public static final String BASE_URL="https://api.themoviedb.org";
    public static final String BASE_PICTURE_URL="http://image.tmdb.org/t/p/w185";
    public BeastMoviesApplication() {
        bus=new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }

    public Bus getBus() {
        return bus;
    }
}

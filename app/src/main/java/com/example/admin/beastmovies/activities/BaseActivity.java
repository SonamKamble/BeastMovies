package com.example.admin.beastmovies.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.beastmovies.infrastructure.BeastMoviesApplication;
import com.squareup.otto.Bus;

/**
 * Created by ADMIN on 16/10/2016.
 */
public class BaseActivity extends AppCompatActivity{
    protected BeastMoviesApplication application;
    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application=(BeastMoviesApplication)getApplication();
        bus=application.getBus();
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}

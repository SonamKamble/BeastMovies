package com.example.admin.beastmovies.live;

import com.example.admin.beastmovies.infrastructure.BeastMoviesApplication;
import com.squareup.otto.Bus;

/**
 * Created by ADMIN on 16/10/2016.
 */
public class BaseLiveService {
    protected BeastMoviesApplication application;
    protected Bus bus;
    protected MovieWebServices api;

    public BaseLiveService(BeastMoviesApplication application,MovieWebServices api) {
        this.application = application;
        this.api=api;
        bus=application.getBus();
        bus.register(this);
    }
}

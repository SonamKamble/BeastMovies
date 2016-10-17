package com.example.admin.beastmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ADMIN on 17/10/2016.
 */
public class ParentModel {
    @SerializedName("results")
    public List<MovieModel> movieInfos;
}

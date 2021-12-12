package com.example.music_api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MusicApi {
    @GET("/adrien?format=json")
    Call<List<Albums>> listAlbums();
}

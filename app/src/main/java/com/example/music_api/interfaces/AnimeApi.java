package com.example.music_api.interfaces;

import com.example.music_api.api_class.Films;
import com.example.music_api.api_class.OneFilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface AnimeApi {
//    @GET("/films")
//    Call<List<Films>> listFilms();

    @GET("/films")
    Observable<List<Films>> listFilms();

//    @GET("/films/{id}")
//    Call<OneFilm> infoFilm(@Path("id") String id);

    @GET("/films/{id}")
    Observable<OneFilm> infoFilm(@Path("id") String id);
}

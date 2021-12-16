package com.example.music_api;

import com.example.music_api.interfaces.AnimeApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    static final String BASE_URL = "https://ghibliapi.herokuapp.com";

    public static AnimeApi getApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        AnimeApi animeApi = retrofit.create(AnimeApi.class);
        return animeApi;

    }

}

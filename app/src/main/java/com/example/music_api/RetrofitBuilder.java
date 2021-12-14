package com.example.music_api;

import com.example.music_api.interfaces.AnimeApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    static final String BASE_URL = "https://ghibliapi.herokuapp.com";
    public static AnimeApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AnimeApi animeApi = retrofit.create(AnimeApi.class);
        return animeApi;

    }

}

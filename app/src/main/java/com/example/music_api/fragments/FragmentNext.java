package com.example.music_api.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.music_api.RetrofitBuilder;
import com.example.music_api.api_class.OneFilm;
import com.example.music_api.interfaces.AnimeApi;
import com.example.music_api.interfaces.OnClickListenerFragment;
import com.example.music_api.R;
import com.squareup.picasso.Picasso;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentNext extends Fragment {
    OnClickListenerFragment onSelectedButtonListener;
    private final String filmId;
    private OneFilm film;
    private static AnimeApi anime;

    private ImageView imageFilm;
    private TextView title, originalTitle, originalTitleRomanised, description,
            director, producer, releaseDate, runningTime, score;


    public FragmentNext(String filmId) {
        this.filmId = filmId;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            onSelectedButtonListener = (OnClickListenerFragment) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View nextV = inflater.inflate(R.layout.fragment_next, container, false);
        film = new OneFilm();
        anime = RetrofitBuilder.getApi();
        updateData();

        imageFilm = nextV.findViewById(R.id.image_film);
        title = nextV.findViewById(R.id.title);
        originalTitle = nextV.findViewById(R.id.original_title);
        originalTitleRomanised = nextV.findViewById(R.id.original_title_romanised);
        description = nextV.findViewById(R.id.description);
        director = nextV.findViewById(R.id.director);
        producer = nextV.findViewById(R.id.producer);
        releaseDate = nextV.findViewById(R.id.release_date);
        runningTime = nextV.findViewById(R.id.running_time);
        score = nextV.findViewById(R.id.rt_score);

        return nextV;
    }

    public void updateData() {
        anime.infoFilm(filmId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OneFilm>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(OneFilm oneFilm) {
                        film = oneFilm;
                        setData();
                    }
                });

//        anime.infoFilm(filmId).enqueue(new Callback<OneFilm>() {
//            @Override
//            public void onResponse(Call<OneFilm> call, Response<OneFilm> response) {
//                film = response.body();
//                setData();
//            }
//
//            @Override
//            public void onFailure(Call<OneFilm> call, Throwable t) {
//                Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void setData() {
        OneFilm oneFilm = film;
        Picasso.get().load(oneFilm.getImage()).resize(220, 400).into(imageFilm);
        title.setText(oneFilm.getTitle());
        originalTitle.setText(oneFilm.getOriginalTitle());
        originalTitleRomanised.setText(oneFilm.getOriginalTitleRomanised());
        description.setText(oneFilm.getDescription());
        director.setText(oneFilm.getDirector());
        producer.setText(oneFilm.getProducer());
        releaseDate.setText(oneFilm.getReleaseDate());
        runningTime.setText(oneFilm.getRunningTime());
        score.setText(oneFilm.getRtScore());
    }
}

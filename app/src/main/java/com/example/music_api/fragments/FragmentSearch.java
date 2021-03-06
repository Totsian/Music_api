package com.example.music_api.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_api.api_class.Films;
import com.example.music_api.RetrofitBuilder;
import com.example.music_api.interfaces.AnimeApi;
import com.example.music_api.interfaces.OnClickListenerFragment;
import com.example.music_api.interfaces.OnItemClickListener;
import com.example.music_api.R;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentSearch extends Fragment {

    OnClickListenerFragment onSelectedButtonListener;
    private RecyclerView recyclerView;
    private List<Films> filmsList;
    private static AnimeApi sAnimeApi;

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
        View searchView = inflater.inflate(R.layout.fragment_search, container, false);

        sAnimeApi = RetrofitBuilder.getApi();
        filmsList = new ArrayList<>();
        callBack();

        recyclerView = searchView.findViewById(R.id.recycler_v);
        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(Films films, int position, String id) {
                onSelectedButtonListener.filmId(3, id);
            }

            @Override
            public void onImageClick(Films films, int position, String id) {
                onSelectedButtonListener.imageId(4, id);
            }

        };
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(llm);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getActivity(), filmsList, itemClickListener);
        recyclerView.setAdapter(recyclerAdapter);

        return searchView;
    }

    public void callBack() {
        sAnimeApi.listFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Films>>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(getActivity(), "Complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(List<Films> films) {
                        filmsList.addAll(films);
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                });

//        sAnimeApi.listFilms().enqueue(new Callback<List<Films>>() {
//            @Override
//            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
//                films.addAll(response.body());
//                recyclerView.getAdapter().notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<List<Films>> call, Throwable t) {
//                Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}

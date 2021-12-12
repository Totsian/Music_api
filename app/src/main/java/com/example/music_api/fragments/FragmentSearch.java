package com.example.music_api.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_api.Albums;
import com.example.music_api.App;
import com.example.music_api.MusicApi;
import com.example.music_api.OnClickListenerFragment;
import com.example.music_api.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSearch extends Fragment implements View.OnClickListener {

    OnClickListenerFragment onSelectedButtonListener;
    private SearchView search;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager llm;
    private List<Albums> albums = new ArrayList<>();
    private static MusicApi musicApi;

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

        musicApi = App.getApi();

        search = searchView.findViewById(R.id.search);

        recyclerView = searchView.findViewById(R.id.recycler_v);
        llm = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerAdapter = new RecyclerAdapter(getActivity(), albums);
        recyclerView.setAdapter(recyclerAdapter);

        musicApi.listAlbums().enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {
                albums.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {
                Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
        return searchView;
    }

    @Override
    public void onClick(View view) {
    }
}

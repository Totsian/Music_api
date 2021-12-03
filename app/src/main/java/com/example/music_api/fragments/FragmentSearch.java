package com.example.music_api.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_api.OnClickListenerFragment;
import com.example.music_api.R;

public class FragmentSearch extends Fragment implements View.OnClickListener {
    OnClickListenerFragment onSelectedButtonListener;
    private SearchView search;
    private RecyclerView recyclerView;

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

        search = searchView.findViewById(R.id.search);
        recyclerView = searchView.findViewById(R.id.recycler_v);

        return searchView;
    }

    @Override
    public void onClick(View view) {
    }
}

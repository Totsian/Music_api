package com.example.music_api.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.music_api.interfaces.OnClickListenerFragment;
import com.example.music_api.R;

public class FragmentStart extends Fragment implements View.OnClickListener {
    OnClickListenerFragment onSelectedButtonListener;
    private Button btn_start, btn_exit;

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
        View startView = inflater.inflate(R.layout.fragment_start, container, false);

        btn_start = startView.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);

        btn_exit = startView.findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(this);

        return startView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                onSelectedButtonListener.onSelectedButton(1);
                break;

            case R.id.btn_exit:
                onSelectedButtonListener.onSelectedButton(2);
                break;
        }
    }
}

package com.example.music_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.music_api.fragments.DialogExit;
import com.example.music_api.fragments.FragmentNext;
import com.example.music_api.fragments.FragmentSearch;
import com.example.music_api.fragments.FragmentStart;
import com.example.music_api.interfaces.OnClickListenerFragment;

public class MainActivity extends AppCompatActivity implements OnClickListenerFragment {

    FragmentTransaction ft;
    FragmentStart fragmentStart;
    FragmentSearch fragmentSearch;
    FragmentNext fragmentNext;
    DialogExit dialogExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getSupportFragmentManager().beginTransaction();
        fragmentStart = new FragmentStart();
        ft.add(R.id.container, fragmentStart);
        ft.commit();
    }


    @Override
    public void onSelectedButton(int btnIndex) {
        if (btnIndex == 1) {
            ft = getSupportFragmentManager().beginTransaction();
            fragmentSearch = new FragmentSearch();
            ft.replace(R.id.container, fragmentSearch);
            ft.addToBackStack(null);
            ft.commit();
        } else if (btnIndex == 2) {
            FragmentManager manager = getSupportFragmentManager();
            dialogExit = new DialogExit();
            dialogExit.show(manager, "DialogExit");
        }
    }

    @Override
    public void filmId(int btnIndex, String id) {
        if (btnIndex == 3) {
            ft = getSupportFragmentManager().beginTransaction();
            fragmentNext = new FragmentNext(id);
            ft.replace(R.id.container, fragmentNext);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
package com.example.music_api.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.music_api.MainActivity;
import com.example.music_api.R;

public class DialogExit extends DialogFragment {
    @Override
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogCustom); // создаем объект, передав ссылку на активность
        builder.setTitle(R.string.exit_text)
                .setPositiveButton(R.string.exit_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity) getActivity()).finish();
                    }

                });
        builder.setNegativeButton(R.string.exit_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        setCancelable(false); // при нажатии на любую часть экрана диалог не исчезает
        return builder.create();
    }
}

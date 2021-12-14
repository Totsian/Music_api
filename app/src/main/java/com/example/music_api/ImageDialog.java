package com.example.music_api;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.squareup.picasso.Picasso;

public class ImageDialog extends DialogFragment {
    private final String imageId;

    public ImageDialog(String imageId) {
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View view = inflater.inflate(R.layout.image_dialog, null);
        ImageView image = view.findViewById(R.id.one_image);
        Picasso.get().load(imageId).resize(720, 1280).into(image);
        builder.setView(view);
        return builder.create();
    }

}
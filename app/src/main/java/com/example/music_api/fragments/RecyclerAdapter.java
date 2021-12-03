package com.example.music_api.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_api.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflate;

    public RecyclerAdapter(LayoutInflater inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflate.inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name_item;
        final TextView option_item;
        final ImageView image_item;
        public ViewHolder(View view) {
            super(view);
            name_item = view.findViewById(R.id.name_item);
            option_item = view.findViewById(R.id.option_item);
            image_item = view.findViewById(R.id.image_item);
        }
    }
}

package com.example.music_api.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_api.Albums;
import com.example.music_api.OnItemClickListener;
import com.example.music_api.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final OnItemClickListener onItemClickListener;
    private final LayoutInflater inflate;
    private final List<Albums> albums;

    public RecyclerAdapter(Context context, List<Albums> albums, OnItemClickListener onItemClickListener) {
        this.albums = albums;
        this.inflate = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Albums album = albums.get(position);
        holder.option_item.setText(album.getText());
        holder.name_item.setText(album.getName());
        Picasso.with(inflate.getContext()).load(album.getImg()).resize(190, 170).into(holder.image_item);
        holder.name_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(album, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (albums == null)
            return 0;
        return albums.size();
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

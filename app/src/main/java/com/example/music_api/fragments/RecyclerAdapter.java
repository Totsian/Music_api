package com.example.music_api.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_api.api_class.Films;
import com.example.music_api.interfaces.OnItemClickListener;
import com.example.music_api.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final OnItemClickListener onItemClickListener;
    private final LayoutInflater inflate;
    private final List<Films> films;

    public RecyclerAdapter(Context context, List<Films> albums, OnItemClickListener onItemClickListener) {
        this.films = albums;
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
        Films film = films.get(position);
        holder.option_item.setText(film.getDirector());
        holder.name_item.setText(film.getTitle());
        Picasso.get().load(film.getImage()).resize(220, 280).into(holder.image_item);

        holder.name_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(film, holder.getAdapterPosition(), film.getId());
            }
        });

        holder.image_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onImageClick(film, holder.getAdapterPosition(), film.getImage());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (films == null)
            return 0;
        return films.size();
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

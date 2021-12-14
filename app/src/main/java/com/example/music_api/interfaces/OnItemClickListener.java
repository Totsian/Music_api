package com.example.music_api.interfaces;

import com.example.music_api.api_class.Films;

public interface OnItemClickListener {
    void onItemClick(Films films, int position, String id);

    void onImageClick(Films films, int position, String image);
}

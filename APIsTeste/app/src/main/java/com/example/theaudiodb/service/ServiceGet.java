package com.example.theaudiodb.service;

import com.example.theaudiodb.model.Playlist;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceGet {


    @GET("id=15524")
    Call<Playlist> getPlaylist();


}

package com.teamfive.trailerflix.api;

import com.teamfive.trailerflix.model.Trailer;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMDBService {

    @GET(".")
    Call<Trailer> recuperarIMDB();
}

package com.teamfive.trailerflix.api;

import com.example.netflix_clone.model.Currency;

import retrofit2.Call;

public interface TrailerService {

    Call<Currency> getCurrency();
}

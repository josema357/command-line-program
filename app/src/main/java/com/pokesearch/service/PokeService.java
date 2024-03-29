package com.pokesearch.service;

import com.pokesearch.model.PokeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeService {
    @GET("pokemon?limit=100000&offset=0")
    Call<PokeResponse> getPokemons();
}

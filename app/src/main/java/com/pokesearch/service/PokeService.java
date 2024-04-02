package com.pokesearch.service;

import com.pokesearch.model.PokeNameResponse;
import com.pokesearch.model.PokeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeService {
    @GET("pokemon?limit=100000&offset=0")
    Call<PokeResponse> getPokemons();

    @GET("pokemon/{pokemon}")
    Call<PokeNameResponse> getByPokeName(@Path("pokemon")String pokemon);
}

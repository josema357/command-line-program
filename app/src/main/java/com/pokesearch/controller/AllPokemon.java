package com.pokesearch.controller;

import com.pokesearch.model.PokeAllResponse;
import com.pokesearch.service.PokeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllPokemon {
    /**
     * static method to request to API call
     * @param service an instance of PokeService class
     */
    public static void requestAllPokemon(PokeService service) {
        Call<PokeAllResponse> call = service.getPokemons();
        call.enqueue(new Callback<PokeAllResponse>() {
            @Override
            public void onResponse(Call<PokeAllResponse> call, Response<PokeAllResponse> response) {
                if (response.isSuccessful()) {
                    PokeAllResponse pokeResponse = response.body();
                    System.out.println(pokeResponse);
                    System.exit(0);
                } else {
                    System.err.println("Error: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokeAllResponse> call, Throwable t) {
                System.err.println("Error when obtaining Pokemons: " + t.getMessage());
            }

        });
    }
}

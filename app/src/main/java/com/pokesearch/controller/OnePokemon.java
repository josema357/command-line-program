package com.pokesearch.controller;

import com.pokesearch.cli.CLIArguments;
import com.pokesearch.model.PokeNameResponse.PokeNameResponse;
import com.pokesearch.service.PokeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnePokemon {
    /**
     * static method to request to API call
     * @param service an instance of the PokeService class
     * @param arguments an instance of CLIArguments containing the name of the Pokemon to retrieve
     */
    public static void requestOnePokemon(PokeService service, CLIArguments arguments) {
        Call<PokeNameResponse> call = service.getByPokeName(arguments.getOnePokemon());
        call.enqueue(new Callback<PokeNameResponse>() {
            @Override
            public void onResponse(Call<PokeNameResponse> call, Response<PokeNameResponse> response) {
                if (response.isSuccessful()) {
                    PokeNameResponse pokeNameResponse = response.body();
                    System.out.println(pokeNameResponse);
                    System.exit(0);
                } else {
                    System.err.println("Error: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokeNameResponse> call, Throwable t) {
                System.err.println("Error when obtaining a Pokemon: " + t.getMessage());
            }

        });
    }
}

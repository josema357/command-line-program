package com.pokesearch.api;

import com.pokesearch.service.PokeService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeApiRetrofit {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    private static Retrofit retrofit;
    /**
     * This method is used to obtain a Retrofit service object for interacting with the PokeApi
     * @return an instance of the PokeService interface
     */
    public static PokeService getService(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit.create(PokeService.class);
    }
}

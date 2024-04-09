package com.pokesearch.controller;

import com.pokesearch.model.RegionAllResponse;
import com.pokesearch.service.PokeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllRegion {
    public static void requestAllRegion(PokeService service) {
        Call<RegionAllResponse> call = service.getRegions();
        call.enqueue(new Callback<RegionAllResponse>() {
            @Override
            public void onResponse(Call<RegionAllResponse> call, Response<RegionAllResponse> response) {
                if(response.isSuccessful()){
                    RegionAllResponse regionResponse = response.body();
                    System.out.println(regionResponse); 
                    System.exit(0);
                }else{
                    System.err.println("Error: " + response.code() + " " + response.message());
                    System.exit(0);
                }
            }
            @Override
            public void onFailure(Call<RegionAllResponse> call, Throwable t) {
                System.err.println("Error when obtaining regions: " + t.getMessage());
            }

        });
    }
}

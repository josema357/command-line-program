package com.pokesearch;

import static com.pokesearch.CommanderFunctions.buildCommanderWithName;
import static com.pokesearch.CommanderFunctions.parseArguments;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.beust.jcommander.JCommander;
import com.pokesearch.api.PokeApiRetrofit;
import com.pokesearch.cli.CLIArguments;
import com.pokesearch.model.PokeNameResponse;
import com.pokesearch.model.PokeResponse;
import com.pokesearch.model.Pokemon;
import com.pokesearch.service.PokeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class App {
    public static void main(String[] args) throws Throwable {
        JCommander jc = buildCommanderWithName("poke-search", CLIArguments::newInstance);
        Stream<CLIArguments> streamCommands = parseArguments(jc, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);

        streamCommands.forEach(arguments -> {
            if (arguments.isAllPokemons()) {
                PokeService service = PokeApiRetrofit.getService();
                Call<PokeResponse> call = service.getPokemons();
                call.enqueue(new Callback<PokeResponse>() {
                    @Override
                    public void onResponse(Call<PokeResponse> call, Response<PokeResponse> response) {
                        if (response.isSuccessful()) {
                            PokeResponse pokeResponse = response.body();
                            List<Pokemon> pokemonList = pokeResponse.getResults();
                            int index = 1;
                            int indexjump = 0;
                            int minWidth = 38;
                            for (Pokemon pokemon : pokemonList) {
                                String outputString = String.format("%-"+ minWidth + "s", "["+index + "] " +pokemon.getName());
                                System.out.print(outputString);
                                if(index-4 == indexjump){
                                    System.out.print("\n");
                                    indexjump=index;
                                }
                                index++;
                            }
                            System.exit(0);
                        } else {
                            System.err.println("Error: " + response.code() + " " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<PokeResponse> call, Throwable t) {
                        System.err.println("Error when obtaining Pokemons: " + t.getMessage());
                    }

                });
            } else if (arguments.getOnePokemon() != null) {
                PokeService service = PokeApiRetrofit.getService();
                Call<PokeNameResponse> call = service.getByPokeName(arguments.getOnePokemon());
                call.enqueue(new Callback<PokeNameResponse>(){
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
        });
    }
}

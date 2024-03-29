package com.pokesearch;

import static com.pokesearch.CommanderFunctions.buildCommanderWithName;
import static com.pokesearch.CommanderFunctions.parseArguments;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.beust.jcommander.JCommander;
import com.pokesearch.api.PokeApiRetrofit;
import com.pokesearch.cli.CLIArguments;
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
                            int index = 0;
                            for (Pokemon pokemon : pokemonList) {
                                System.out.println("["+index + "] " +pokemon.getName());
                                index++;
                            }
                            System.exit(0);
                        } else {
                            System.err.println("Error: " + response.code() + " " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PokeResponse> call, Throwable t) {
                        System.err.println("Error al obtener Pokemons: " + t.getMessage());
                    }

                });
            } else if (arguments.getKeyword() != null) {
                System.out.println("Search by pokemon name");
                System.exit(0);
            }
        });
    }
}
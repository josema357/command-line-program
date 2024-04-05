package com.pokesearch;

import static com.pokesearch.CommanderFunctions.buildCommanderWithName;
import static com.pokesearch.CommanderFunctions.parseArguments;

import java.util.Collections;
import java.util.stream.Stream;

import com.beust.jcommander.JCommander;
import com.pokesearch.api.PokeApiRetrofit;
import com.pokesearch.cli.CLIArguments;
import com.pokesearch.controller.AllPokemon;
import com.pokesearch.controller.OnePokemon;
import com.pokesearch.service.PokeService;

/**
 * Usage:
 * --all: Request information for all Pokemon
 * --name: Request information for a specific Pokemon by name
 */
public class App {
    public static void main(String[] args) throws Throwable {
        PokeService service = PokeApiRetrofit.getService();
        JCommander jc = buildCommanderWithName("poke-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamCommands = parseArguments(jc, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);
        
        streamCommands.forEach(arguments -> {
            /**
             * The user enters the --all argument
             */
            if (arguments.isAllPokemons()) {
                AllPokemon.requestAllPokemon(service);
            }
            /**
             * The user enters the --name argument 
             */ 
            else if (arguments.getOnePokemon() != null) {
                OnePokemon.requestOnePokemon(service, arguments);
            }
        });
    }
}

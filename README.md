# Command line program with Functional Java:
This project demonstrates the use of JCommander, Retrofit, and functional Java to build a command line application that interacts with an API.
## # Used technology:
- [JCommander](https://jcommander.org/) `v.1.82` 
- [Retrofit2](https://square.github.io/retrofit/) `v.2.10`
- [Converter Gson](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson) `v.2.10`
- [Lombok](https://projectlombok.org/) `v.1.18.32`
- [Rxjava3](https://github.com/ReactiveX/RxJava) `3.1.8`
- [Adapter Rxjava3](https://github.com/square/retrofit/blob/trunk/retrofit-adapters/rxjava3/README.md) `v.2.10`

## # Arguments
- `--all` request information for all Pokemon
- `--name` request information for a specific Pokemon by name
- `--region` request information for all region

## # Project structure
``` 
/src
    /main
        /java
            /com/pokesreach
                /api
                    PokeApiRetrofit.java
                /cli
                    /validators
                        CLIHelpValidator.java
                        CLIKeywordValidator.java
                    CLIArguments.java
                /controller
                    AllPokemon.java
                    AllRegion.java
                    OnePokemon.java
                /model
                    /pokeNameResponse
                        PokeNameResponse.java
                    PokeAllResponse.java
                    Pokemon.java
                    RegionAllResponse.java
                /service
                    PokeService.java
                App.java
                CommanderFunctions.java
```
## # Use
```
Usage: poke-search [options] Terminal tool keyword
  Options:
    --all, -a
      show all pokemon names
      Default: false
    --help
      Show help
    --name, -n
      show information about a pokemon
    --region, -r
      Show all region names
      Default: false
```
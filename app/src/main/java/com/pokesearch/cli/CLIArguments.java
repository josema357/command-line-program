package com.pokesearch.cli;

import com.beust.jcommander.Parameter;

import lombok.Getter;

@Getter
public class CLIArguments {
    CLIArguments(){

    }
    @Parameter(
        required = true,
        descriptionKey = "KEYWORD",
        description = "Terminal tool keyword"
    )
    private String keyword;
    @Parameter(
        names = {"--all", "-a"},
        description = "show all pokemon names"
    )
    private boolean allPokemons;
    @Parameter(
        names = {"--name", "-n"},
        validateWith = CLIKeywordValidator.class,
        description = "show information about a pokemon"
    )
    private String onePokemon;
    @Parameter(
        names = "--help",
        help = true,
        validateWith = CLIHelpValidator.class,
        description = "Show help"
    )
    private boolean isHelp;

    @Override
    public String toString() {
        return "CLIArguments [keyword = " + keyword + ", all = " + allPokemons + ",isHelp = " + isHelp + "]";
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}

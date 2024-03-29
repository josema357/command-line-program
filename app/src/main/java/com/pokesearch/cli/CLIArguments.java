package com.pokesearch.cli;

import com.beust.jcommander.Parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CLIArguments {
    CLIArguments(){

    }
    @Parameter(
        required = true,
        descriptionKey = "KEYWORD",
        validateWith = CLIKeywordValidator.class,
        description = "KEYWORD"
    )
    private String keyword;
    @Parameter(
        names = {"--all", "-a"},
        description = "show all pokemons"
    )
    private boolean allPokemons;
    @Parameter(
        names = {"--page", "-p"},
        description = "the API return 20 results, use a number to the page"
    )
    private int page = 0;
    @Parameter(
        names = "--help",
        help = true,
        validateWith = CLIHelpValidator.class,
        description = "Show help"
    )
    private boolean isHelp;

    @Override
    public String toString() {
        return "CLIArguments [keyword = " + keyword + ", all = " + allPokemons + ", page = " + page + ",isHelp = " + isHelp + "]";
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}

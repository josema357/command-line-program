package com.pokesearch.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PokeAllResponse {
    private int count;
    private String next;
    private String previous;
    private List<Pokemon> results;

    @Override
    public String toString() {
        String output = "Resource for all pokemons: \n"
                + "total amount : " + count + "\n";
        int index = 1;
        int indexjump = 0;
        int minWidth = 38;
        for (Pokemon pokemon : results) {
            output += String.format("%-" + minWidth + "s", "[" + index + "] " + pokemon.getName());
            if (index - 4 == indexjump) {
                output += "\n";
                indexjump = index;
            }
            index++;
        }

        return output;

    }
}

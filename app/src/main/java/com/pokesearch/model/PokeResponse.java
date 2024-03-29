package com.pokesearch.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class PokeResponse {
    private int count;
    private String next;
    private String previous;
    private List<Pokemon> results;
}

package com.pokesearch.model.PokeNameResponse;

import lombok.Data;

@Data
public class PokeStats {
    private Integer base_stat;
    private Integer effort;
    private Stat stat;
}

@Data
class Stat {
    private String name;
    private String url;
}

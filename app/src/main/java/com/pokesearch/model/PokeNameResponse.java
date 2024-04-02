package com.pokesearch.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PokeNameResponse {
    private String name;
    private Integer id;
    private Double height;
    private Double weight;
    @Override
    public String toString() {
        return "Resource for " + name.substring(0, 1).toUpperCase() + name.substring(1) + "\n"
            + "order : " + id + "\n" 
            + "name : " + name + "\n"
            + "height : " + height/10 + "m" + "\n" 
            + "weight : " + weight/10 + "kg";
    }

    
}

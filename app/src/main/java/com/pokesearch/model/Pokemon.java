package com.pokesearch.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Pokemon {
    private String name;
    private String url;
}

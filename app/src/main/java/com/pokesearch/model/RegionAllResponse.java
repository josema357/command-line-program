package com.pokesearch.model;

import java.util.List;

import lombok.Data;

@Data
public class RegionAllResponse {
  private Integer count;
  private List<Region> results;

  @Override
  public String toString() {
    String output = "Resource for all regions: \n"
        + "Total amount : " + count + "\n";
    int index = 1;
    int indexjump = 0;
    int minWidth = 20;
    for (Region region : results) {
      output += String.format("%-" + minWidth + "s", "[" + index + "] " + region.getName());
      if (index - 4 == indexjump) {
        output += "\n";
        indexjump = index;
      }
      index++;
    }
    return output;
  }
}

@Data
class Region {
  private String name;
  private String url;
}
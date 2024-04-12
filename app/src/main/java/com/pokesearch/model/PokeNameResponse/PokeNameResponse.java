package com.pokesearch.model.PokeNameResponse;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PokeNameResponse {
  private String name;
  private Integer id;
  private Double height;
  private Double weight;
  private List<PokeStats> stats;

  @Override
  public String toString() {
    String output = "Resource for " + name.substring(0, 1).toUpperCase() + name.substring(1) + "\n"
        + "order : " + id + "\n"
        + "name : " + name + "\n"
        + "height : " + height / 10 + "m" + "\n"
        + "weight : " + weight / 10 + "kg" + "\n"
        + "stats : \n";
    if(stats != null && !stats.isEmpty()){
      for (PokeStats stat : stats){
        output += " - name_stat : " + stat.getStat().getName()+ "\n" 
            + " - base_stat : " + stat.getBase_stat() + "\n"
            + " - effort : " + stat.getEffort() + "\n";
      }
    }
    return output;
  }

}

@Data
class PokeStats {
    private Integer base_stat;
    private Integer effort;
    private Stat stat;
}

@Data
class Stat {
    private String name;
    private String url;
}

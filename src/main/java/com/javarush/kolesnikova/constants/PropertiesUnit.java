package com.javarush.kolesnikova.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
public class PropertiesUnit {

    private final String icon;
    private final String name;
    private final Double weight;
    private final int speed;
    private final int maxUnitsInCell;
    private final Double kilogramOfFood;


   private static final Map<String, PropertiesUnit> unitsPropertiesMap = Map.of(
            "Wolf", new PropertiesUnit("","Волк", 50.0, 3, 30, 8.0),
            "Rabbit", new PropertiesUnit("","Заяц", 20., 2, 150, 0.45));

   public PropertiesUnit unitsProperties (String unit){
       return unitsPropertiesMap.get(unit);
   }

}

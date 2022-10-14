package com.javarush.kolesnikova.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

import static com.javarush.kolesnikova.constants.UnitsName.*;


@AllArgsConstructor
@Getter
public class PropertiesUnit {

    private final String icon;
    private final String name;
    private final Double weight;
    private final int speed;
    private final int maxUnitsInCell;
    private final Double kilogramOfFood;

    // сделать енамом и заюзать в фабрике
    private static final Map<UnitsName, PropertiesUnit> unitsPropertiesMap = Map.of(
            WOLF, new PropertiesUnit("", "Волк", 50.0, 3, 30, 8.0),
            RABBIT, new PropertiesUnit("", "Заяц", 20., 2, 150, 0.45),
            HERB, new PropertiesUnit("", "Заяц", 20., 2, 150, 0.45));


    private static final int[][] chanceToHaveDinner = new int[UnitsName.values().length][UnitsName.values().length];


}

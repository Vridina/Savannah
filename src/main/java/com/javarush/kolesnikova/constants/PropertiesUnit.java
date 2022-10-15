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
            WOLF, new PropertiesUnit("", "Волк", 50.0, 3, 3, 8.0),
            RABBIT, new PropertiesUnit("", "Заяц", 20., 2, 15, 0.45),
            HERB, new PropertiesUnit("", "Трава", 20., 2, 15, 0.45));


    public static PropertiesUnit unitsProperties(UnitsName unitsName) {
        return unitsPropertiesMap.get(unitsName);
    }


    private static final int[][] chanceToHaveDinner = new int[UnitsName.values().length][UnitsName.values().length];


    public static int[][] chanceToHaveDinner() {

        chanceToHaveDinner[WOLF.ordinal()][RABBIT.ordinal()] = 60;
        chanceToHaveDinner[WOLF.ordinal()][HERB.ordinal()] = 0;

        chanceToHaveDinner[RABBIT.ordinal()][RABBIT.ordinal()] = 60;
        chanceToHaveDinner[RABBIT.ordinal()][HERB.ordinal()] = 100;

        return chanceToHaveDinner;
    }
}




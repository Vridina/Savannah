package com.javarush.kolesnikova.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.Map;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import static java.nio.charset.StandardCharsets.*;
import static java.nio.charset.StandardCharsets.UTF_8;


@AllArgsConstructor
@Getter
public class PropertiesUnit {


    private final String icon;
    private final String name;
    private final Double weight;
    private final int speed;
    private final int maxUnitsInCell;
    private final Double kilogramOfFood;


    public enum UnitsName {WOLF, RABBIT, HERB}

    public static EnumSet<UnitsName> allUnits() {
        return EnumSet.allOf(UnitsName.class);
    }

    private static final Map<UnitsName, PropertiesUnit> unitsPropertiesMap = Map.of(
            WOLF, new PropertiesUnit(new String("\uD83D\uDC3A".getBytes(ISO_8859_1), UTF_8), "Волк", 50.0, 3, 3, 8.0),
            RABBIT, new PropertiesUnit("\uD83D\uDC07", "Заяц", 20., 2, 5, 0.45),
            HERB, new PropertiesUnit("\uD83C\uDF3F", "Трава", 20., 2, 5, 0.45));


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




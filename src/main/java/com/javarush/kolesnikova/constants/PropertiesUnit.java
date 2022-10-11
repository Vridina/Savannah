package com.javarush.kolesnikova.constants;

import com.javarush.kolesnikova.entities.units.unitsMaker.RabbitMaker;
import com.javarush.kolesnikova.entities.units.unitsMaker.UnitMaker;
import com.javarush.kolesnikova.entities.units.unitsMaker.WolfMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PropertiesUnit {

    private final String name;
    private final Double weight;
    private final int speed;
    private final int maxUnitsInCell;
    private final Double kilogramOfFood;

    private PropertiesUnit(String name, Double weight, int speed, int maxUnitsInCell, Double kilogramOfFood) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
        this.maxUnitsInCell = maxUnitsInCell;
        this.kilogramOfFood = kilogramOfFood;
    }

   public static final Map<String, PropertiesUnit> unitsPropertiesMap = Map.of(
            "Wolf", new PropertiesUnit("Волк", 50.0, 3, 30, 8.0),
            "Rabbit", new PropertiesUnit("Заяц", 20., 2, 150, 0.45));

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxUnitsInCell() {
        return maxUnitsInCell;
    }

    public Double getKilogramOfFood() {
        return kilogramOfFood;
    }
}

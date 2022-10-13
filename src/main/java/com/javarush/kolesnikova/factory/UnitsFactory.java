package com.javarush.kolesnikova.factory;

import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.factory.unitsFactory.*;



import java.util.Map;

public class UnitsFactory {


    private final static Map<String, UnitFactory> unitsMakerMap = Map.of(
            "Wolf", new WolfFactory(),
            "Rabbit", new RabbitFactory(),
            "Herb", new HerbFactory());

    public static Unit getUnitMaker(String maker) {
        UnitFactory unitFactory = unitsMakerMap.get(maker);
        return unitFactory.makeUnit();
    }
}

package com.javarush.kolesnikova.factory;

import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.factory.unitsMaker.HerbFactory;
import com.javarush.kolesnikova.factory.unitsMaker.RabbitFactory;
import com.javarush.kolesnikova.factory.unitsMaker.UnitFactory;
import com.javarush.kolesnikova.factory.unitsMaker.WolfFactory;


import java.util.Map;

public class UnitsFactory {


    static Map<String, UnitFactory> unitsMakerMap = Map.of(
            "Wolf", new WolfFactory(),
            "Rabbit", new RabbitFactory(),
            "Herb", new HerbFactory());

    public static Unit getUnitMaker(String maker) {
        UnitFactory unitFactory = unitsMakerMap.get(maker);
        return unitFactory.makeUnit();
    }
}

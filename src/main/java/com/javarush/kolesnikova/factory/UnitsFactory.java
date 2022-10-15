package com.javarush.kolesnikova.factory;

import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.factory.unitsFactory.*;


import java.util.Map;


public class UnitsFactory {


    private final static Map<String, UnitFactory> unitsMakerMap = Map.of(
            "WOLF", new WolfFactory(),
            "RABBIT", new RabbitFactory(),
            "HERB", new HerbFactory());

    public static Unit getUnit(UnitsName name) {
        UnitFactory unitFactory = unitsMakerMap.get(name);
        System.out.printf("Рожден тип %s. ", name );
        return unitFactory.makeUnit();

    }

}

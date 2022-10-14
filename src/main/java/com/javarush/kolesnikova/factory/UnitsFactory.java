package com.javarush.kolesnikova.factory;

import com.javarush.kolesnikova.constants.UnitsName;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.factory.unitsFactory.*;


import java.util.Map;

import static com.javarush.kolesnikova.constants.UnitsName.*;

public class UnitsFactory {


    private final static Map<UnitsName, UnitFactory> unitsMakerMap = Map.of(
            WOLF, new WolfFactory(),
            RABBIT, new RabbitFactory(),
            HERB, new HerbFactory());

    public static Unit getUnitMaker(String maker) {
        UnitFactory unitFactory = unitsMakerMap.get(maker);
        return unitFactory.makeUnit();
    }
}

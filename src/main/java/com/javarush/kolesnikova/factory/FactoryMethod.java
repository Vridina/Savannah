package com.javarush.kolesnikova.factory;

import com.javarush.kolesnikova.factory.unitsMaker.RabbitMaker;
import com.javarush.kolesnikova.factory.unitsMaker.UnitMaker;
import com.javarush.kolesnikova.factory.unitsMaker.WolfMaker;


import java.util.Map;

public class FactoryMethod {


    static Map<String, UnitMaker> unitsMakerMap = Map.of(
            "Wolf", new WolfMaker(),
            "Rabbit", new RabbitMaker());

    public static UnitMaker getUnitMaker(String maker) {
        return unitsMakerMap.get(maker);

    }
}

package com.javarush.kolesnikova.entities.units;

import com.javarush.kolesnikova.entities.units.unitsMaker.RabbitMaker;
import com.javarush.kolesnikova.entities.units.unitsMaker.UnitMaker;
import com.javarush.kolesnikova.entities.units.unitsMaker.WolfMaker;


import java.util.Map;

public class FactoryMethod {


    static Map<String, UnitMaker> unitsMakerMap = Map.of(
            "Wolf", new WolfMaker(),
            "Rabbit", new RabbitMaker());

 public static UnitMaker getUnitMaker(String maker){
     return unitsMakerMap.get(maker);

 }
}

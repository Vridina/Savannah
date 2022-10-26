package com.javarush.kolesnikova.factory;

import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.factory.unitsFactory.*;


import java.util.Map;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;


public class UnitsFactory {


    private final static Map<UnitsName, UnitFactory> unitsMakerMap = Map.ofEntries(
            Map.entry(WOLF, new WolfFactory()),
            Map.entry(SNAKE, new SnakeFactory()),
            Map.entry(FOX, new FoxFactory()),
            Map.entry(BEAR, new BearFactory()),
            Map.entry(EAGLE, new EagleFactory()),
            Map.entry(HORSE, new HorseFactory()),
            Map.entry(DEER, new DeerFactory()),
            Map.entry(RABBIT, new RabbitFactory()),
            Map.entry(MOUSE, new MouseFactory()),
            Map.entry(GOAT, new GoatFactory()),
            Map.entry(SHEEP, new SheepFactory()),
            Map.entry(HOG, new HogFactory()),
            Map.entry(BUFFALO, new BuffaloFactory()),
            Map.entry(DUCK, new DuckFactory()),
            Map.entry(CATERPILLAR, new CaterpillarFactory()),
            Map.entry(HERB, new HerbFactory()));

    public static Unit getUnit(UnitsName name) {
        UnitFactory unitFactory = unitsMakerMap.get(name);
        return unitFactory.makeUnit();

    }

}

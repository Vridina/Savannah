package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Duck;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.DUCK;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class DuckFactory implements UnitFactory {


    @Override
    public Duck makeUnit() {
        return new Duck(unitsProperties(DUCK));
    }
}


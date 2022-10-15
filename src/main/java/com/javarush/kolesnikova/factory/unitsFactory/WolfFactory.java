package com.javarush.kolesnikova.factory.unitsFactory;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import com.javarush.kolesnikova.entities.units.carnivorous.Wolf;

import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;


public class WolfFactory implements UnitFactory {


    @Override
    public  Wolf makeUnit() {
        return new Wolf(unitsProperties(WOLF));
    }
}


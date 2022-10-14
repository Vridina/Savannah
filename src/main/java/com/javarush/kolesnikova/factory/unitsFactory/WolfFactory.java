package com.javarush.kolesnikova.factory.unitsFactory;

import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.entities.units.carnivorous.Wolf;

import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;
import static com.javarush.kolesnikova.constants.UnitsName.WOLF;

public class WolfFactory implements UnitFactory {


    @Override
    public  Wolf makeUnit() {
        return new Wolf(unitsProperties(WOLF));
    }
}


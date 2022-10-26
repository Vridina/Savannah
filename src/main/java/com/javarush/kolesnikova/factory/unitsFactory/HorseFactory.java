package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Horse;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class HorseFactory implements UnitFactory {


    @Override
    public Horse makeUnit() {
        return new Horse(unitsProperties(HORSE));
    }
}


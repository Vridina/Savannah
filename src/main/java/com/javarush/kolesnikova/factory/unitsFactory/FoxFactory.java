package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.carnivorous.Fox;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class FoxFactory implements UnitFactory {


    @Override
    public Fox makeUnit() {
        return new Fox(unitsProperties(FOX));
    }
}


package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Sheep;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class SheepFactory implements UnitFactory {


    @Override
    public Sheep makeUnit() {
        return new Sheep(unitsProperties(SHEEP));
    }
}


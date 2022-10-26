package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Deer;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class DeerFactory implements UnitFactory {


    @Override
    public Deer makeUnit() {
        return new Deer(unitsProperties(DEER));
    }
}


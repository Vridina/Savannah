package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Buffalo;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.BUFFALO;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class BuffaloFactory implements UnitFactory {


    @Override
    public Buffalo makeUnit() {
        return new Buffalo(unitsProperties(BUFFALO));
    }
}


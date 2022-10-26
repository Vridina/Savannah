package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.carnivorous.Bear;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.BEAR;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class BearFactory implements UnitFactory {


    @Override
    public Bear makeUnit() {
        return new Bear(unitsProperties(BEAR));
    }
}


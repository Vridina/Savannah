package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Caterpillar;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.CATERPILLAR;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class CaterpillarFactory implements UnitFactory {


    @Override
    public Caterpillar makeUnit() {
        return new Caterpillar(unitsProperties(CATERPILLAR));
    }
}


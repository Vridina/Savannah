package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Hog;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class HogFactory implements UnitFactory {


    @Override
    public Hog makeUnit() {
        return new Hog(unitsProperties(HOG));
    }
}


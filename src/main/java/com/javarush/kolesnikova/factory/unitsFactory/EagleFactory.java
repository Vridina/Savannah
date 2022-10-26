package com.javarush.kolesnikova.factory.unitsFactory;



import com.javarush.kolesnikova.entities.units.carnivorous.Eagle;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class EagleFactory implements UnitFactory {


    @Override
    public Eagle makeUnit() {
        return new Eagle(unitsProperties(EAGLE));
    }
}


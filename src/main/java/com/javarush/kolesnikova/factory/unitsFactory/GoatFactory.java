package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Goat;
import com.javarush.kolesnikova.entities.units.herbivores.Horse;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.GOAT;
import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.HORSE;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class GoatFactory implements UnitFactory {


    @Override
    public Goat makeUnit() {
        return new Goat(unitsProperties(GOAT));
    }
}


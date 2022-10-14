package com.javarush.kolesnikova.factory.unitsFactory;



import com.javarush.kolesnikova.entities.units.plants.Herb;

import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;
import static com.javarush.kolesnikova.constants.UnitsName.HERB;

public class HerbFactory  implements UnitFactory {


    @Override
    public  Herb makeUnit() {
        return new Herb(unitsProperties(HERB));
    }
}


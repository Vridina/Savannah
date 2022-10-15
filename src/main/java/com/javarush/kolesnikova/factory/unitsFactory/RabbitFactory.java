package com.javarush.kolesnikova.factory.unitsFactory;

import com.javarush.kolesnikova.entities.units.herbivores.Rabbit;

import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;
import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;

public class RabbitFactory implements UnitFactory {

    @Override
    public  Rabbit makeUnit() {
        return new Rabbit(unitsProperties(RABBIT));
    }
}

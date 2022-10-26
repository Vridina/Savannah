package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.carnivorous.Snake;

import static com.javarush.kolesnikova.constants.PropertiesUnit.*;
import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.*;

public class SnakeFactory implements UnitFactory {


    @Override
    public Snake makeUnit() {
        return new Snake(unitsProperties(SNAKE));
    }
}


package com.javarush.kolesnikova.factory.unitsFactory;


import com.javarush.kolesnikova.entities.units.herbivores.Mouse;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.MOUSE;
import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsProperties;

public class MouseFactory implements UnitFactory {


    @Override
    public Mouse makeUnit() {
        return new Mouse(unitsProperties(MOUSE));
    }
}


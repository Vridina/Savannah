package com.javarush.kolesnikova.entities.units.unitsMaker;

import com.javarush.kolesnikova.entities.units.animals.carnivorous.Wolf;

public class WolfMaker implements UnitMaker {

    @Override
    public Wolf makeUnit() {
        return new Wolf();
    }
}


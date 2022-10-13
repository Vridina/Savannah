package com.javarush.kolesnikova.factory.unitsMaker;

import com.javarush.kolesnikova.entities.units.animals.carnivorous.Wolf;

public class WolfMaker extends UnitMaker {

    @Override
    public Wolf makeUnit() {
        return new Wolf();
    }
}


package com.javarush.kolesnikova.factory.unitsMaker;

import com.javarush.kolesnikova.entities.units.carnivorous.Wolf;

public class WolfFactory implements UnitFactory {


    @Override
    public  Wolf makeUnit() {
        return new Wolf("\\uD83D\\uDC3A",
                "Wolf",
                50.0,
                3,
                30,
                8.0);
    }
}


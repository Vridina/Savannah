package com.javarush.kolesnikova.entities.units.unitsMaker;



import com.javarush.kolesnikova.entities.units.plants.Herb;

public class HerbMaker implements UnitMaker {


    @Override
    public Herb makeUnit() {
        return new Herb();
    }
}


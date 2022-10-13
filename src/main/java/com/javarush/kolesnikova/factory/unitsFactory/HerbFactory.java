package com.javarush.kolesnikova.factory.unitsFactory;



import com.javarush.kolesnikova.entities.units.plants.Herb;

public class HerbFactory  implements UnitFactory {


    @Override
    public  Herb makeUnit() {
        return new Herb("\\uD83C\\uDF39",
                "Herb",
                1.0,
                200);
    }
}


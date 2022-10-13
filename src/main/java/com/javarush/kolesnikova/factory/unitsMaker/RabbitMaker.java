package com.javarush.kolesnikova.factory.unitsMaker;

import com.javarush.kolesnikova.entities.units.herbivores.Rabbit;

public class RabbitMaker extends UnitMaker {

    @Override
    public Rabbit makeUnit() {
        return new Rabbit();
    }
}

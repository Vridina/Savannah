package com.javarush.kolesnikova.entities.units.unitsMaker;

import com.javarush.kolesnikova.entities.units.animals.herbivores.Rabbit;

public class RabbitMaker implements UnitMaker {

    @Override
    public Rabbit makeUnit() {
        return new Rabbit();
    }
}

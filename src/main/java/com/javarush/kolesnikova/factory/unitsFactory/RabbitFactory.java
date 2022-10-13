package com.javarush.kolesnikova.factory.unitsFactory;

import com.javarush.kolesnikova.entities.units.herbivores.Rabbit;

public class RabbitFactory implements UnitFactory {

    @Override
    public  Rabbit makeUnit() {
        return new Rabbit("\\uD83D\\uDC07",
                "Rabbit",
                2.0,
                2,
                150,
                0.45);
    }
}

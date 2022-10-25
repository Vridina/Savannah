package com.javarush.kolesnikova.entities.units;


import com.javarush.kolesnikova.actions.Eating;
import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.actions.Running;
import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.entities.field.Cell;


import java.util.concurrent.ThreadLocalRandom;


public abstract class Animals extends Unit
        implements Reproduction, Eating, Running {


    public Animals(PropertiesUnit propertiesUnit) {
        this.icon = propertiesUnit.getIcon();
        this.name = propertiesUnit.getName();
        this.weight = propertiesUnit.getWeight();
        this.maxUnitsInCell = propertiesUnit.getMaxUnitsInCell();
        this.speed = propertiesUnit.getSpeed();
        this.kilogramOfFood = propertiesUnit.getKilogramOfFood();
        this.id = getId();


    }

    @Override
    public void run() {
        super.run();
    }

    }




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

    @Override
    public void eating() {
        System.out.println("_____________ќбъект пытаетс€ кого нить съесть:)))");
    }

    @Override
    public void running(Cell cell) {
        System.out.printf("ќбъект пытаетс€ убежать из €чейки %d | %d \n", cell.getX(), cell.getY());
        int newX = cell.getX() + ThreadLocalRandom.current().nextInt(0, speed - 1);
        int newY = cell.getY() + ThreadLocalRandom.current().nextInt(0, speed - 1);
        boolean isMove = true;
        if (newX >= 20 || newY >= 100 || newX < 0 || newY < 0) {
            isMove = false;
        }
        if (newX == cell.getX() && newY == cell.getY()) {
            isMove = false;
        }
        if (isMove) {


            }



        }

    }




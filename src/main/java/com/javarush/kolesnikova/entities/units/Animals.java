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
    }


    @Override
    public void eating(Unit unit) {

    }

    @Override
    public void running(Cell cell) {
        int newX = cell.getX() + ThreadLocalRandom.current().nextInt(0,speed);
        int newY = cell.getY() + ThreadLocalRandom.current().nextInt(0,speed);
        boolean isMove = true;
        if (newX >= 20 || newY >= 100 || newX < 0 || newY < 0 ) {
            isMove = false;
        }
        if (newX == cell.getX()  && newY == cell.getY()){
            isMove = false;
        }
        if (isMove) {
            // страрой ячейки удаляем в новую записывауаем
        }

    }

//    void eat(Herbivore herbivore) {
//        String carnivoreName = getClass().getSimpleName();
//        String herbivoreName = herbivore.getClass().getSimpleName();
//
//        PropertiesUnit propertiesCarnivore = unitsPropertiesMap.get(carnivoreName);
//        Double carnivoreKilogramOfFood = propertiesCarnivore.getKilogramOfFood();
//
//
//        PropertiesUnit propertiesHerbivore = unitsPropertiesMap.get(herbivoreName);
//        Double herbivoreWeight = propertiesHerbivore.getWeight();
//
//        System.out.printf("%s съедает %s\n", carnivoreName, herbivoreName);
//        System.out.printf("---Вес %s равен %f\n",  herbivoreName, herbivoreWeight);
//        System.out.printf("---%s надо %f кг еды для насыщения\n",  carnivoreName, carnivoreKilogramOfFood);
//
//    }
//
//     void run1() {
//        System.out.println(getClass().getSimpleName() + " бегает.");
//
//    }

}

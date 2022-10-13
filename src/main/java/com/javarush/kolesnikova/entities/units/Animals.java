package com.javarush.kolesnikova.entities.units;


import com.javarush.kolesnikova.actions.Eating;
import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.actions.Running;



public abstract class Animals extends Unit
        implements Reproduction, Eating, Running {


    public Animals(String icon, String name, Double weight, int speed, int maxUnitsInCell, Double kilogramOfFood) {
        super(icon, name, weight, speed, maxUnitsInCell, kilogramOfFood);
    }

    @Override
    public void eating(Unit unit) {

    }

    @Override
    public void running(Unit unit) {

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

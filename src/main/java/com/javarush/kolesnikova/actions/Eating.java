package com.javarush.kolesnikova.actions;


import com.javarush.kolesnikova.entities.units.Unit;


public interface Eating {
    void eating(Unit init);

//
//    void eat () {
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
//    }

}

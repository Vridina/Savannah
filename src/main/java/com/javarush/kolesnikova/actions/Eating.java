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
//        System.out.printf("%s ������� %s\n", carnivoreName, herbivoreName);
//        System.out.printf("---��� %s ����� %f\n",  herbivoreName, herbivoreWeight);
//        System.out.printf("---%s ���� %f �� ��� ��� ���������\n",  carnivoreName, carnivoreKilogramOfFood);
//    }

}

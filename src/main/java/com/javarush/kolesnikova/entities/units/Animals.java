package com.javarush.kolesnikova.entities.units;


import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.entities.units.animals.carnivorous.Carnivore;
import com.javarush.kolesnikova.entities.units.animals.herbivores.Herbivore;

import static com.javarush.kolesnikova.constants.PropertiesUnit.unitsPropertiesMap;

public interface Animals {

    default void eat( Herbivore herbivore) {
//        System.out.println(getClass().getSimpleName() + " ест.");
        String carnivoreName = getClass().getSimpleName();
        String herbivoreName = herbivore.getClass().getSimpleName();

        PropertiesUnit propertiesCarnivore = unitsPropertiesMap.get(carnivoreName);
        Double carnivoreKilogramOfFood = propertiesCarnivore.getKilogramOfFood();


        PropertiesUnit propertiesHerbivore = unitsPropertiesMap.get(herbivoreName);
        Double herbivoreWeight = propertiesHerbivore.getWeight();

        System.out.printf("%s съедает %s\n", carnivoreName, herbivoreName);
        System.out.printf("---Вес %s равен %f\n",  herbivoreName, herbivoreWeight);
        System.out.printf("---%s надо %f кг еды для насыщения\n",  carnivoreName, carnivoreKilogramOfFood);

    }

    default void run() {
        System.out.println(getClass().getSimpleName() + " бегает.");

    }

}

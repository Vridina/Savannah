package com.javarush.kolesnikova.entities.units.herbivores;


import com.javarush.kolesnikova.entities.units.Animals;

public abstract class Herbivore extends Animals {

    public Herbivore(String icon, String name, Double weight, int speed, int maxUnitsInCell, Double kilogramOfFood) {
        super(icon, name, weight, speed, maxUnitsInCell, kilogramOfFood);
    }
}

package com.javarush.kolesnikova.entities.units;


import com.javarush.kolesnikova.actions.Reproduction;


public abstract class Plants extends Unit
        implements Reproduction {


    public Plants(String icon, String name, Double weight, int maxUnitsInCell) {
        super(icon, name, weight, maxUnitsInCell);
    }
}


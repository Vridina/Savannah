package com.javarush.kolesnikova.entities.units;


import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.constants.PropertiesUnit;


public abstract class Plants extends Unit
        implements Reproduction {


    public Plants(PropertiesUnit propertiesUnit) {

        this.icon = propertiesUnit.getIcon();
        this.name = propertiesUnit.getName();
        this.weight = propertiesUnit.getWeight();
        this.maxUnitsInCell = propertiesUnit.getMaxUnitsInCell();
        this.id = getId();
    }
}



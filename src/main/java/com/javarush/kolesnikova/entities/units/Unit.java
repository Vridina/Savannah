package com.javarush.kolesnikova.entities.units;

import com.javarush.kolesnikova.actions.Reproduction;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode
public class Unit
        implements Runnable, Cloneable, Reproduction {



    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
    }


    @Override
    public void reproduction(Unit unit) {

    }
}


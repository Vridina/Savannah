package com.javarush.kolesnikova.entities.units;

import com.javarush.kolesnikova.actions.Reproduction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode
@Setter
@Getter
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
        String s = getClass().getSimpleName();
        System.out.println(s + " поток запустился");

    }


    @Override
    public void reproduction(Unit unit) {

    }
}


package com.javarush.kolesnikova.entities.units;

import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.constants.PropertiesUnit;
import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;


@EqualsAndHashCode
@Setter
@Getter
@ToString
public abstract class Unit
        implements Runnable, Cloneable, Reproduction {

    final static AtomicInteger atomicInteger = new AtomicInteger(0);
    final int numberUnit = atomicInteger.incrementAndGet();
    String icon;
    String name;
    Double weight;
    int speed;
    int maxUnitsInCell;
    Double kilogramOfFood;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        String s = getClass().getSimpleName();
        System.out.println(s + " поток для объекта запустился");
        reproduction();
    }


    @Override
    public void reproduction() {
        String s = getClass().getSimpleName();
        System.out.println(s + "Объект размножается размножением)))");
    }
}


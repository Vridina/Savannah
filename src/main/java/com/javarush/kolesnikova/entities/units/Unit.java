package com.javarush.kolesnikova.entities.units;

import com.javarush.kolesnikova.actions.Reproduction;
import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;


@EqualsAndHashCode
@Setter
@Getter
@ToString
public class Unit
        implements Runnable, Cloneable, Reproduction {

    final static AtomicInteger atomicInteger = new AtomicInteger(0);
    final int numberUnit = atomicInteger.incrementAndGet();
    String icon;
    String name;
    Double weight;
    int speed;
    int maxUnitsInCell;
    Double kilogramOfFood;



    public Unit(String icon, String name, Double weight, int maxUnitsInCell) {
        this.icon = icon;
        this.name = name;
        this.weight = weight;
        this.maxUnitsInCell = maxUnitsInCell;
    }

    public Unit(String icon, String name, Double weight, int speed, int maxUnitsInCell, Double kilogramOfFood) {
        this.icon = icon;
        this.name = name;
        this.weight = weight;
        this.speed = speed;
        this.maxUnitsInCell = maxUnitsInCell;
        this.kilogramOfFood = kilogramOfFood;
    }


    @Override
    public Object clone() {
        System.out.println("Клон ->" + numberUnit);
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


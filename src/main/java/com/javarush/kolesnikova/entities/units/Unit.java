package com.javarush.kolesnikova.entities.units;

import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.exceptions.GameException;
import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;


@EqualsAndHashCode
@Setter
@Getter
@ToString
public abstract class Unit
        implements Runnable, Cloneable, Reproduction {

    private final static AtomicInteger atomicInteger = new AtomicInteger(0);

    int id;

    String icon;
    String name;
    Double weight;
    int speed;
    int maxUnitsInCell;
    Double kilogramOfFood;


    private int getIncrementId() {
        return atomicInteger.incrementAndGet();
    }

    @Override
    public Unit clone() {
        try {
            Unit clone = (Unit) super.clone();
            clone.setId(clone.getIncrementId());
            return clone;

        } catch (CloneNotSupportedException e) {
            throw new GameException(e);
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
        System.out.printf("\nОбъект %s %d размножается размножением.", s,getId());
    }
}


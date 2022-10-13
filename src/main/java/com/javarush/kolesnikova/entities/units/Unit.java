package com.javarush.kolesnikova.entities.units;

import com.javarush.kolesnikova.actions.Reproduction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;


@EqualsAndHashCode
@Setter
@Getter
@ToString
public class Unit
        implements Runnable, Cloneable, Reproduction {

    AtomicInteger numberUnit = new AtomicInteger(0);


    private final String icon = getIcon();
    private final String name =
    private final Double weight;
    private final int speed;
    private final int maxUnitsInCell;
    private final Double kilogramOfFood;


    @Override
    public Object clone() {
        numberUnit.getAndIncrement();
        System.out.println("Клон ->"+ numberUnit.get());
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


package com.javarush.kolesnikova.entities.units;


public interface Unit extends Animals, Plants {


    default void multiply() {
        System.out.println("Берем 2 юнита и прибавляем 1, но не больше чем может быть в клетке юнитов данного типа | " + getClass().getSimpleName());
    }

}


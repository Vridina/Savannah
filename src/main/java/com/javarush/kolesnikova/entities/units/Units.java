package com.javarush.kolesnikova.entities.units;

public interface Unit extends Animals {


    public default void multiply(){
        System.out.println(getClass().getSimpleName() +  " размножается.");
    }



}

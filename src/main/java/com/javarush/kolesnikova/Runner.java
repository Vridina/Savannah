package com.javarush.kolesnikova;


import com.javarush.kolesnikova.entities.field.GameField;
import com.javarush.kolesnikova.entities.units.Unit;

import static com.javarush.kolesnikova.factory.UnitsFactory.getUnitMaker;


public class Runner {

    public static void main(String[] args) {
        System.out.println("Запуск.");

        GameField.createGame();

        Unit wolf = getUnitMaker("Wolf");
        wolf.run();
        wolf.toString();
        Unit cloneWolf = (Unit) wolf.clone();


        System.out.println(wolf.getNumberUnit());
        System.out.println(cloneWolf.getNumberUnit());


    }


}

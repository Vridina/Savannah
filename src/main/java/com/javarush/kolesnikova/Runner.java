package com.javarush.kolesnikova;


import com.javarush.kolesnikova.entities.field.GameField;

import static com.javarush.kolesnikova.factory.UnitsFactory.getUnitMaker;


public class Runner {

    public static void main(String[] args) {
        System.out.println("Запуск.");

        GameField.createGame();

        getUnitMaker("Wolf").run();


    }


}

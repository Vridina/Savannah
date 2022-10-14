package com.javarush.kolesnikova;


import com.javarush.kolesnikova.constants.UnitsName;
import com.javarush.kolesnikova.controller.MainController;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.Arrays;

import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;


public class Runner {

    public static void main(String[] args) {
        System.out.println("Запуск.");



        Unit wolf = getUnit(UnitsName.valueOf("WOLF"));
        wolf.run();
        wolf.toString();
        Unit cloneWolf = (Unit) wolf.clone();


        System.out.println(wolf.getNumberUnit());
        System.out.println(cloneWolf.getNumberUnit());
        System.out.println("количесво енамов - "+((UnitsName.values()).length));
        System.out.println("________________________");


       MainController.startApp();

    }


}

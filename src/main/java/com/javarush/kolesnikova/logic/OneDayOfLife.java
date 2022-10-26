package com.javarush.kolesnikova.logic;


import com.javarush.kolesnikova.actions.Eating;
import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.actions.Running;


public class OneDayOfLife {

    public static void start() {

        for (int i = 0; i < 50; i++) {
            System.out.println("\n=================  День " + (i + 1) + " =================");
            Analytics.getCellsStat();
            Reproduction.multiply();
            Running.run();
            Eating.eat();

        }
    }
}


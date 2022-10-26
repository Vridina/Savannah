package com.javarush.kolesnikova.logic;


import com.javarush.kolesnikova.actions.Eating;
import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.actions.Running;


public class OneDayOfLife {

    public static void start() {
        int i = 1;
        while (true) {
            System.out.println("\n=================  День " + (i) + " =================");
            i++;
            if (Analytics.getCellsStat() > 0) {
                Reproduction.multiply();
                Running.run();
                Eating.eat();
            } else {
                break;
            }

        }
    }
}


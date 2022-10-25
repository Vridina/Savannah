package com.javarush.kolesnikova.logic;


import com.javarush.kolesnikova.actions.Eating;
import com.javarush.kolesnikova.actions.Reproduction;
import com.javarush.kolesnikova.actions.Running;
import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.entities.field.Cell;

import static com.javarush.kolesnikova.entities.field.GameField.*;

public class OneDayOfLife {

    public static void start() {

        for (int i = 0; i < 2; i++) {
            System.out.println("\n=================  Δενό " + (i + 1) + " =================");
            Analytics.getCellsStat();
            Reproduction.multiply();
            Running.run();
            Eating.eat();

        }
    }
}


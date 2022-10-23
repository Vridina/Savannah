package com.javarush.kolesnikova.logic;


public class OneDayOfLife {

    public static void start() {

        for (int i = 0; i < 2; i++) {
            System.out.println("\n=================  Δενό " + (i + 1) + " =================");
            Actions.actions();

        }
    }
}


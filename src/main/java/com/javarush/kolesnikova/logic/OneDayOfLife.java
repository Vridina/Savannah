package com.javarush.kolesnikova.logic;


public class OneDayOfLife {

    public static void start() {
        System.out.println("\n \nЗапускаем 1 день в мире животных:");
        for (int i = 0; i < 2; i++) {
            System.out.println("\n\nНаступил день номер " +  (i + 1));
            Actions.actions();


        }

    }




}



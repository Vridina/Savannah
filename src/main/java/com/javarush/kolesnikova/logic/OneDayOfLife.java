package com.javarush.kolesnikova.logic;


public class OneDayOfLife {

    public static void start() {
        System.out.println("\n \nЗапускаем 1 день в мире животных:");
        for (int i = 0; i < 2; i++) {
            Actions.actions();
            System.out.println("Наступил день номер " + i+1);
        }

    }




}



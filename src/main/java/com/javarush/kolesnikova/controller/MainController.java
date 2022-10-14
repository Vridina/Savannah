package com.javarush.kolesnikova.controller;


import com.javarush.kolesnikova.logic.OneDayOfLife;
import com.javarush.kolesnikova.logic.WordCreate;

public class MainController {


    public static void startApp() {
        WordCreate.create();
        OneDayOfLife.start();
        printStatistic();
    }




    public static void printStatistic() {
        System.out.println("Вывели статистику за 1 день");
    }



}

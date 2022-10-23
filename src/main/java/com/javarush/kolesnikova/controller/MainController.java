package com.javarush.kolesnikova.controller;


import com.javarush.kolesnikova.logic.OneDayOfLife;
import com.javarush.kolesnikova.logic.WordCreate;

public class MainController {


    public static void startApp() {
        WordCreate.create();
        OneDayOfLife.start();
    }







}

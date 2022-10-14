package com.javarush.kolesnikova.controller;

import com.javarush.kolesnikova.constants.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.field.GameField;

import static com.javarush.kolesnikova.entities.field.GameField.createGameField;


public class WordCreate {


    public static void create() {
        System.out.println("Создем мир и населяем животными: ");
        createGameField();

    }

    public static void oneDayLife() {
        System.out.println("Прошел 1 день в мире");
    }

    public static void printStatistic() {
        System.out.println("Вывели статистику за 1 день");
    }

}
package com.javarush.kolesnikova.controller;

import com.javarush.kolesnikova.entities.field.GameField;


public class MainController {

    // заселяем поле животными и растениями
    void initialize() {
         GameField gameField = new GameField();
        System.out.println("Создали поле");


        System.out.println("тут создаем животных");
    }

    // делаем шаг
    public void makeStep() {

        System.out.println("Сделали шаг");
    }

    // статистику на экран
    public void printState() {
        System.out.println("Статистика выведена на экран");
    }
}

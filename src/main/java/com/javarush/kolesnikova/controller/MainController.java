package com.javarush.kolesnikova.controller;

import com.javarush.kolesnikova.entities.field.GameField;
import com.javarush.kolesnikova.logic.Step;

public class MainController {

    // заселяем поле животными и растениями
    void initialize() {
        final GameField gameField = new GameField();
        System.out.println("Создали поле");


        System.out.println("тут создаем животных");
    }

    // делаем шаг
    public void makeStep() {
        new Step();
        System.out.println("Сделали шаг");
    }

    // статистику на экран
    public void printState() {
        System.out.println("Статистика выведена на экран");
    }
}

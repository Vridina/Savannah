package com.javarush.kolesnikova.controller;

import com.javarush.kolesnikova.constants.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.field.GameField;

import static com.javarush.kolesnikova.entities.field.GameField.createGameField;


public class WordCreate {


    public static void create() {
        System.out.println("������ ��� � �������� ���������: ");
        createGameField();

    }

    public static void oneDayLife() {
        System.out.println("������ 1 ���� � ����");
    }

    public static void printStatistic() {
        System.out.println("������ ���������� �� 1 ����");
    }

}
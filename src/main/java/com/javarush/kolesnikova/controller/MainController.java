package com.javarush.kolesnikova.controller;

import com.javarush.kolesnikova.entities.field.GameField;
import com.javarush.kolesnikova.logic.Step;

public class MainController {

    // �������� ���� ��������� � ����������
    void initialize() {
        final GameField gameField = new GameField();
        System.out.println("������� ����");


        System.out.println("��� ������� ��������");
    }

    // ������ ���
    public void makeStep() {
        new Step();
        System.out.println("������� ���");
    }

    // ���������� �� �����
    public void printState() {
        System.out.println("���������� �������� �� �����");
    }
}

package com.javarush.kolesnikova.controller;

import com.javarush.kolesnikova.entities.field.GameField;


public class MainController {

    // �������� ���� ��������� � ����������
    void initialize() {
         GameField gameField = new GameField();
        System.out.println("������� ����");


        System.out.println("��� ������� ��������");
    }

    // ������ ���
    public void makeStep() {

        System.out.println("������� ���");
    }

    // ���������� �� �����
    public void printState() {
        System.out.println("���������� �������� �� �����");
    }
}

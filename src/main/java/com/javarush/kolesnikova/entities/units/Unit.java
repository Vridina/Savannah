package com.javarush.kolesnikova.entities.units;


public interface Unit extends Animals, Plants {


    default void multiply() {
        System.out.println("����� 2 ����� � ���������� 1, �� �� ������ ��� ����� ���� � ������ ������ ������� ���� | " + getClass().getSimpleName());
    }

}


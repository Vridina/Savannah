package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.exceptions.GameException;

import java.util.HashSet;
import java.util.Iterator;

import static com.javarush.kolesnikova.entities.field.GameField.*;

public class OneDayOfLife {

    // ����� ������, ��������� ��� (�����������, ����� �������� � ���������, ����� ����������� �� ��������� �����������)
    public static void start() {
        System.out.println("\n \n��������� 1 ���� � ���� ��������:");
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                HashSet<Unit> unitsInCell = cell.getUnitsInCell();
                if (!unitsInCell.isEmpty()) {
                    Iterator<Unit> iterator = unitsInCell.iterator();
                    while (iterator.hasNext()){
                        Unit unit = iterator.next();
                        unit.reproduction();


                    }
                } else throw new GameException();

            }

        }


    }

}

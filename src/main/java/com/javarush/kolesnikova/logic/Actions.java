package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.field.GameField;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.HERB;
import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;



public class Actions {


    public static void actions() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                multiply(cell);
                running(cell);
            }
        }
    }

    private static void multiply(Cell cell) {
        for (UnitsName unitsName : cell.getUnitsInCell().keySet()) {
            Unit unitInstance = getUnit(unitsName);
            int maxUnitsInCell = unitInstance.getMaxUnitsInCell();
            Set<Unit> units = cell.getSetUnitsInCell(unitsName);
            int numberOfOneTypeOfUnits = units.size(); // ����� ������� ���� ������ ���� unitsName �� ������� ��� ���� ����  �� ���� ���������� �� ������� ����
            if (!unitsName.equals(HERB)) {
                int numberOfNewUnitsMax = numberOfOneTypeOfUnits / 2;
                int numberOfNewUnitsResult;
                if (maxUnitsInCell >= (numberOfNewUnitsMax + numberOfOneTypeOfUnits)) {
                    numberOfNewUnitsResult = numberOfNewUnitsMax;
                } else {
                    numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
                }
                for (int i = 0; i < numberOfNewUnitsResult; i++) {
                    units.add(unitInstance.clone());
                }
                System.out.printf("� ������ %d | %d ����� %d  %s. ���� ������� %d �������. ����� ����� __ %d\n",
                        cell.getX(), cell.getY(), numberOfOneTypeOfUnits, unitsName, numberOfNewUnitsResult, cell.getUnitsInCell().get(unitsName).size());
            } else {
                int numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits; // ����� ������� ����� �� ����������
                for (int i = 0; i < numberOfNewUnitsResult; i++) {
                    units.add(unitInstance.clone());
                }
                System.out.printf("� ������ %d | %d ������ %d %s. ������� %d ��������. ����� ����� __ %d.\n",
                        cell.getX(), cell.getY(), numberOfOneTypeOfUnits, unitsName, numberOfNewUnitsResult,
                        cell.getUnitsInCell().get(unitsName).size());

            }
        }
    }


    private static void running(Cell cell) {
        for (UnitsName unitsName : cell.getUnitsInCell().keySet()) {
            Set<Unit> units = cell.getSetUnitsInCell(unitsName);
            HashSet<Unit> unitsCopy = new HashSet<>(units);

            if (!unitsName.equals(HERB)) {
//                for (Unit nextUnit : units)
                Iterator<Unit> unitIterator = unitsCopy.iterator();
                while (unitIterator.hasNext()) {
                    Unit nextUnit = unitIterator.next();
                    int maxUnitsInCell = nextUnit.getMaxUnitsInCell();

                    int[] one = new int[]{-1, 1};
                    int takeOne = ThreadLocalRandom.current().nextInt(0, 1);


                    int newX = cell.getX() + (ThreadLocalRandom.current().nextInt(0, nextUnit.getSpeed()) * one[takeOne]);
                    int newY = cell.getY() + (ThreadLocalRandom.current().nextInt(0, nextUnit.getSpeed()) * one[takeOne]);

                    if (newX < 0) {
                        newX *= -1;
                    }
                    if (newY < 0) {
                        newY *= -1;
                    }
//                System.out.printf("������ �������� ������� �� ������ %d | %d, � ����� ������ %d | %d\n",
//                        cell.getX(), cell.getY(), newX, newY);

                    boolean isMove = true;
                    if (newX >= GameField.getColX() || newY >= GameField.getRowY() || newX < 0 || newY < 0) {

                        System.out.printf("%s �������� ������� �� ������ %d | %d, � ����� ������ %d | %d ---> ",
                                units.iterator().next().getName(), cell.getX(), cell.getY(), newX, newY);
                        System.out.println("��������� - ����� �� ������� ����");
                    } else if (newX == cell.getX() && newY == cell.getY()) {

                        System.out.printf("%s �������� ������� �� ������ %d | %d, � ����� ������ %d | %d ---> ",
                                units.iterator().next().getName(), cell.getX(), cell.getY(), newX, newY);
                        System.out.println("��������� - �� �� ������");
                    } else {
                        Cell cellTarget = getField()[newY][newX];
                        Set<Unit> setUnitsInCellTarget = cellTarget.getSetUnitsInCell(unitsName);
                        int numberOfOneTypeOfUnitsInNewCell = setUnitsInCellTarget.size();
                        if (numberOfOneTypeOfUnitsInNewCell >= maxUnitsInCell) {
                            System.out.printf("%s �������� ������� �� ������ %d | %d, � ����� ������ %d | %d ---> ",
                                    units.iterator().next().getName(), cell.getX(), cell.getY(), newX, newY);
                            System.out.println("��������� - ������ ������������");
                            isMove = false;
                        }
                        if (isMove) {
                            System.out.printf("%s �������� ������� �� ������ %d | %d, � ����� ������ %d | %d ---> ",
                                    units.iterator().next().getName(), cell.getX(), cell.getY(), newX, newY);
                            System.out.println("����������� ������� ~~~~~");
                            setUnitsInCellTarget.add(nextUnit.clone());
                            units.remove(nextUnit);
                        }

                    }
                }


            } else {
                System.out.println("����� �� ������, ��� ��)");
            }


        }


    }
}




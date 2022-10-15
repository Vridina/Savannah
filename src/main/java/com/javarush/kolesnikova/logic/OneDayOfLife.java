package com.javarush.kolesnikova.logic;


import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.HERB;
import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;

public class OneDayOfLife {

    // ����� ������, ��������� ��� (�����������, ����� �������� � ���������, ����� ����������� �� ��������� �����������)
    // ����� ����� ��� (�������� �� �������) � ��������� �������� �� ����� ����� ����� ��������
    // �� �� ������ ��� ����� ���� � ������. (�� �������� ��� �����!)

    public static void start() {
        System.out.println("\n \n��������� 1 ���� � ���� ��������:");
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                HashMap<UnitsName, Set<Unit>> unitsInCell = cell.getUnitsInCell();
                for (UnitsName unitsName : unitsInCell.keySet()) {
                    Unit unitInstance = getUnit(unitsName);
                    int maxUnitsInCell = unitInstance.getMaxUnitsInCell();
                    if (!unitsName.equals(HERB)) {
                        Set<Unit> units = unitsInCell.get(unitsName);
                        int numberOfOneTypeOfAnimal = units.size();
                        int numberOfNewAnimalMax = numberOfOneTypeOfAnimal / 2;
                        int numberOfNewAnimalResult;
                        if (maxUnitsInCell >= (numberOfNewAnimalMax + numberOfOneTypeOfAnimal)) {
                            numberOfNewAnimalResult = numberOfNewAnimalMax;
                        } else {
                            numberOfNewAnimalResult = maxUnitsInCell - numberOfOneTypeOfAnimal;
                        }
                        Set<Unit> unitsOneTypeSet = new HashSet<>();
                        for (int i = 0; i < numberOfNewAnimalResult; i++) {
                            unitsOneTypeSet.add(unitInstance.clone());
                        }
                        unitsInCell.put(unitsName, unitsOneTypeSet);
                    } else {
                        System.out.println("����� ������");
                        // todo - ����������� ��� �����
                    }


                }


            }


        }

    }


}



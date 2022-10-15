package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.HERB;
import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;

public class Actions{


    public static void reproduction() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                HashMap<PropertiesUnit.UnitsName, Set<Unit>> unitsInCell = cell.getUnitsInCell();
                for (PropertiesUnit.UnitsName unitsName : unitsInCell.keySet()) {
                    Unit unitInstance = getUnit(unitsName);
                    int maxUnitsInCell = unitInstance.getMaxUnitsInCell();
                    Set<Unit> units = unitsInCell.get(unitsName);
                    int numberOfOneTypeOfUnits = units.size();
                    if (!unitsName.equals(HERB)) {
                        int numberOfNewUnitsMax = numberOfOneTypeOfUnits / 2;
                        int numberOfNewUnitsResult;
                        if (maxUnitsInCell >= (numberOfNewUnitsMax + numberOfOneTypeOfUnits)) {
                            numberOfNewUnitsResult = numberOfNewUnitsMax;
                        } else {
                            numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
                        }
                        Set<Unit> unitsOneTypeSet = new HashSet<>();
                        for (int i = 0; i < numberOfNewUnitsResult; i++) {
                            unitsOneTypeSet.add(unitInstance.clone());
                        }
                        unitsInCell.put(unitsName, unitsOneTypeSet);
                        System.out.printf("В ячейке %d | %d живет %d  %s. Было рождено %d малышей. \n", cell.getX(), cell.getY(), numberOfOneTypeOfUnits, unitsName, numberOfNewUnitsResult);
                    } else {
                        int numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
                        Set<Unit> unitsOneTypeSet = new HashSet<>();
                        for (int i = 0; i < numberOfNewUnitsResult; i++) {
                            unitsOneTypeSet.add(unitInstance.clone());
                        }
                        unitsInCell.put(unitsName, unitsOneTypeSet);
                        System.out.printf("В ячейке %d | %d растет %d %s. Выросло %d травинок. \n", cell.getX(), cell.getY(), numberOfOneTypeOfUnits, unitsName, numberOfNewUnitsResult);
                    }
                }
            }
        }
    }
}




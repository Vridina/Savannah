package com.javarush.kolesnikova.actions;


import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Animals;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.Set;

import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;

public interface Reproduction {



    static void multiply() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                for (PropertiesUnit.UnitsName name : cell.getUnitsInCell().keySet()) {
                    int maxUnitsInCell = getUnit(name).getMaxUnitsInCell();
                    Set<Unit> units = cell.getSetUnitsInCell(name);
                    int numberOfOneTypeOfUnits = units.size();

                    if (getUnit(name) instanceof Animals) {
                        int numberOfNewUnitsMax = numberOfOneTypeOfUnits / 2;
                        int numberOfNewUnitsResult;
                        if (maxUnitsInCell >= (numberOfNewUnitsMax + numberOfOneTypeOfUnits)) {
                            numberOfNewUnitsResult = numberOfNewUnitsMax;
                        } else {
                            numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
                        }
                        for (int i = 0; i < numberOfNewUnitsResult; i++) {
                            units.add(getUnit(name).clone());
                        }
//                        System.out.printf("� %d|%d - %d %s. ������� %d. ����� %d/%d\n",
//                                cell.getX(), cell.getY(), numberOfOneTypeOfUnits, name, numberOfNewUnitsResult,
//                                cell.getUnitsInCell().get(name).size(), maxUnitsInCell);
                    } else {
                        int numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
                        for (int i = 0; i < numberOfNewUnitsResult; i++) {
                            units.add(getUnit(name).clone());
                        }
//                        System.out.printf("� %d|%d - %d %s. ������� %d. ����� %d/%d\n",
//                                cell.getX(), cell.getY(), numberOfOneTypeOfUnits, name, numberOfNewUnitsResult,
//                                cell.getUnitsInCell().get(name).size(), maxUnitsInCell);
                    }
                }
            }
        }
    }
}







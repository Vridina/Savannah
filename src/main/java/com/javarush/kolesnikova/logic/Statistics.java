package com.javarush.kolesnikova.logic;


import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Set;

import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;

@AllArgsConstructor
public class Statistics {


    UnitsName unitsName;
    int unitsStart;
    int unitsNew;
    int unitsDied;

    HashMap<UnitsName, Integer> resultOfTheDay;


    public Statistics review() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                for (UnitsName unitsName : cell.getUnitsInCell().keySet()) {
                    Unit unitInstance = getUnit(unitsName);
                    int maxUnitsInCell = unitInstance.getMaxUnitsInCell();
                    Set<Unit> units = cell.getSetUnitsInCell(unitsName);
                    int numberOfOneTypeOfUnits = units.size();


                }
            }
        }

        return null;

    }


    @Override
    public String toString() {
        int unitsResult = unitsStart + unitsNew - unitsDied;
        return unitsName +
                " - " + unitsStart +
                "/ + " + unitsNew +
                "/ - " + unitsDied +
                " = " + unitsResult;
    }
}


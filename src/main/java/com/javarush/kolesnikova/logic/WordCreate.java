package com.javarush.kolesnikova.logic;


import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.*;

import static com.javarush.kolesnikova.constants.PropertiesUnit.allUnits;
import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;
import static com.javarush.kolesnikova.utils.Utils.getRandom;


public class WordCreate {

    public static void create() {

        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                HashMap<UnitsName, Set<Unit>> unitsInCell = new HashMap<>();
                Cell cell = new Cell(x, y, unitsInCell);
                Cell[][] field = getField();
                field[y][x] = cell;
                for (UnitsName name : allUnits()) {
                    Unit unit = getUnit(name);
                    int maxUnitsInCell = unit.getMaxUnitsInCell();
                    int numRandom = getRandom(maxUnitsInCell);
                    Set<Unit> unitsOneTypeSet = new HashSet<>();
                    for (int n = 0; n < numRandom; n++) {
                        unitsOneTypeSet.add(unit.clone());
                    }
                    unitsInCell.put(name, unitsOneTypeSet);
                }

            }

        }
    }


}
package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.entities.units.carnivorous.Carnivore;
import com.javarush.kolesnikova.entities.units.herbivores.Herbivore;

import java.util.HashMap;

import java.util.Set;

import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;


public class Analytics {


    public static void getCellsStat() {

        HashMap<UnitsName, Integer> mapStatistic = new HashMap<>(); // в мапу собираем статистику
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                for (UnitsName name : cell.getUnitsInCell().keySet()) {
                    Set<Unit> setUnitsInCell = cell.getSetUnitsInCell(name);
                    int size = setUnitsInCell.size();
                    if (mapStatistic.containsKey(name) && mapStatistic.get(name) > 0) {
                        int i = mapStatistic.get(name) + (Integer) size;
                        mapStatistic.put(name, i);
                    } else {
                        mapStatistic.put(name, size);
                    }
                }
            }
        }
        for (UnitsName name : mapStatistic.keySet()) {
            if (mapStatistic.get(name) > 0) {
                System.out.printf("%s %s = %d  ",
                        getUnit(name).getIcon(), getUnit(name).getName(), mapStatistic.get(name));
            }

        }
        System.out.println();
    }

}





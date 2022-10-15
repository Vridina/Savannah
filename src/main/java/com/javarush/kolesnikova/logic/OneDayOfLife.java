package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.entities.units.carnivorous.Wolf;
import com.javarush.kolesnikova.exceptions.GameException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.javarush.kolesnikova.entities.field.GameField.*;

public class OneDayOfLife {

    // взять ячейку, запустить РАН (размножение, потом поедание с умиранием, потом перемещение по известным координатам)
    // потом взять его (округлив до четного) и прибавить половину от этого числа новых объектов
    // но не больше чем может быть в ячейке. (не подходит для травы!)

    public static void start() {
        System.out.println("\n \nЗапускаем 1 день в мире животных:");
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                HashMap<UnitsName, Set<Unit>> unitsInCell = cell.getUnitsInCell();
                for (UnitsName unitsName : unitsInCell.keySet()) {
                    if (!unitsName.equals(UnitsName.HERB)) {
                        System.out.println("Животные плодятся " + unitsName );
                        int numberOfOneTypeOfAnimal = unitsInCell.get(unitsName).size();
                    } else {
                        System.out.println("Трава растет");
                        // todo - размножение для травы
                    }


                }




            }


        }

    }


}



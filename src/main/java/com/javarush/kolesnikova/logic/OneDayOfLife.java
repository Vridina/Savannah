package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.HashSet;

import static com.javarush.kolesnikova.entities.field.GameField.*;

public class OneDayOfLife {


    public static void start() {
        System.out.println("\n \nЗапускаем 1 день в мире животных:");

        Cell[][] field = getField();
        // взять ячейку, запустить РАН (размножение, потом поедание с умиранием, потом перемещение по известным координатам)


        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                HashSet<Unit> unitsInCell = cell.getUnitsInCell();
                Unit next = unitsInCell.stream().iterator().next();
                next.run();
            }

        }


    }

}

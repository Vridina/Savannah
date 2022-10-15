package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.entities.units.carnivorous.Wolf;
import com.javarush.kolesnikova.exceptions.GameException;

import java.util.HashSet;
import java.util.Iterator;

import static com.javarush.kolesnikova.entities.field.GameField.*;

public class OneDayOfLife {

    // вз€ть €чейку, запустить –јЌ (размножение, потом поедание с умиранием, потом перемещение по известным координатам)
    // так как у мен€ все вповалку, то надо сначала посчитать сколько всего объектов данного вида в €чейке
    // потом вз€ть его (округлив до четного) и прибавить половину от этого числа новых объектов
    // но не больше чем может быть в €чейке. (не подходит дл€ травы!)

    public static void start() {
        System.out.println("\n \n«апускаем 1 день в мире животных:");
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                HashSet<Unit> unitsInCell = cell.getUnitsInCell();
                if (!unitsInCell.isEmpty()) {
                    Iterator<Unit> iterator = unitsInCell.iterator();
                    while (iterator.hasNext()) {
                        Unit unit = iterator.next();
                        if (unit instanceof Wolf) {

                        }

//                        unit.reproduction();
                    }
                } else throw new GameException();

            }

        }


    }

}

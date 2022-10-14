package com.javarush.kolesnikova.entities.field;


import com.javarush.kolesnikova.constants.UnitsName;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.entities.units.carnivorous.Wolf;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;

public class GameField {

    private static final int rowY = 2;
    private static final int colX = 10;


    private static final Cell[][] field = new Cell[rowY][colX];

    static ExecutorService executorService = Executors.newWorkStealingPool();

    //  создание пол€ с €чейками, каждой €чейке присваиваютс€ координаты x и добавл€ютс€ в массив field.
    public static Cell[][] createGameField() {
        for (int y = 0; y < rowY; y++) {
            for (int x = 0; x < colX; x++) {
                HashSet<Unit> unitsInCell = new HashSet<>();
                Cell cell = new Cell(x, y, unitsInCell);
                field[y][x] = cell;
                UnitsName[] unitsNames = UnitsName.values();
                for (UnitsName unitsName : unitsNames) {
                    Unit unit = getUnit(unitsName);
                    int maxUnitsInCell = unit.getMaxUnitsInCell();
                    int num = ThreadLocalRandom.current().nextInt(0, maxUnitsInCell);
                    System.out.printf("макс число в €чейке %d , создан  %d %s \n", maxUnitsInCell, num, unit.getName());
                    for (int n = 0; n < num; n++) {
                        Unit clone = (Unit) unit.clone();
                        unitsInCell.add(clone);
                        executorService.submit(clone);
                    }
                }
            }
            System.out.println("\n \n Ќова€ строка ______________");

            //todo -  а на кого делать потоки, в какой момент создать сервис и добавл€ть их?
        }
        return field;
    }

}

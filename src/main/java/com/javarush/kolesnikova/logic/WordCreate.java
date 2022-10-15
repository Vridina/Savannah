package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;


public class WordCreate {

    //todo -  а на кого делать потоки, в какой момент создать сервис и добавл€ть их?
    //    static ExecutorService executorService = Executors.newWorkStealingPool();
    //     executorService.submit(clone);


    //  создание пол€ с €чейками, каждой €чейке присваиваютс€ координаты x и добавл€ютс€ в массив field
    //  создаем животных и засел€ем в €чейки.

    public static void create() {
        System.out.println("—оздаем мир и насел€ем животными: ");
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                HashSet<Unit> unitsInCell = new HashSet<>();
                Cell cell = new Cell(x, y, unitsInCell);
                Cell[][] field = getField();
                field[y][x] = cell;
                UnitsName[] unitsNames = UnitsName.values();
                for (UnitsName unitsName : unitsNames) {
                    Unit unit = getUnit(unitsName);
                    int maxUnitsInCell = unit.getMaxUnitsInCell();
                    int numRandom = ThreadLocalRandom.current().nextInt(0, maxUnitsInCell);
                    System.out.printf("ћакс число животных данного вида в €чейке %d. —оздано %d %s \n", maxUnitsInCell, numRandom, unit.getName());
                    for (int n = 0; n < numRandom; n++) {
                        unitsInCell.add(unit.clone());
                    }
                    System.out.println(unitsInCell);
                }
            }
            System.out.println("\n \n Ќова€ строка ______________");


        }

    }
}
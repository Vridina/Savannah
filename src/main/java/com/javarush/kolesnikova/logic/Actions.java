package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.field.GameField;
import com.javarush.kolesnikova.entities.units.Unit;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName.HERB;
import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;


public class Actions {


    public static void actions() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                multiply(cell);
                running(cell);
            }
        }
    }

    private static void multiply(Cell cell) {
        for (UnitsName unitsName : cell.getUnitsInCell().keySet()) {
            Unit unitInstance = getUnit(unitsName);
            int maxUnitsInCell = unitInstance.getMaxUnitsInCell();
            Set<Unit> units = cell.getSetUnitsInCell(unitsName);
            int numberOfOneTypeOfUnits = units.size();
            if (!unitsName.equals(HERB)) {
                int numberOfNewUnitsMax = numberOfOneTypeOfUnits / 2;
                int numberOfNewUnitsResult;
                if (maxUnitsInCell >= (numberOfNewUnitsMax + numberOfOneTypeOfUnits)) {
                    numberOfNewUnitsResult = numberOfNewUnitsMax;
                } else {
                    numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
                }
                for (int i = 0; i < numberOfNewUnitsResult; i++) {
                    units.add(unitInstance.clone());
                }
                System.out.printf("¬ €чейке %d | %d живет %d  %s. Ѕыло рождено %d малышей. ¬сего стало __ %d\n",
                        cell.getX(), cell.getY(), numberOfOneTypeOfUnits, unitsName, numberOfNewUnitsResult, cell.getUnitsInCell().get(unitsName).size());
            } else {
                int numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
                for (int i = 0; i < numberOfNewUnitsResult; i++) {
                    units.add(unitInstance.clone());
                }
                System.out.printf("¬ €чейке %d | %d растет %d %s. ¬ыросло %d травинок. ¬сего стало __ %d.\n",
                        cell.getX(), cell.getY(), numberOfOneTypeOfUnits, unitsName, numberOfNewUnitsResult,
                        cell.getUnitsInCell().get(unitsName).size());

            }
        }
    }


    private static void running(Cell cell) {
        for (UnitsName unitsName : cell.getUnitsInCell().keySet()) {
            Set<Unit> units = cell.getSetUnitsInCell(unitsName);
            if (!unitsName.equals(HERB)) {
                for (Unit nextUnit : units) {
                               int maxUnitsInCell = nextUnit.getMaxUnitsInCell();
                    int newX = cell.getX() + ThreadLocalRandom.current().nextInt(0, nextUnit.getSpeed() - 1);
                    int newY = cell.getY() + ThreadLocalRandom.current().nextInt(0, nextUnit.getSpeed() - 1);

                    if (newX < 0) {
                        newX *= -1;
                    }
                    if (newY < 0) {
                        newY *= -1;
                    }
//                System.out.printf("ќбъект пытаетс€ убежать из €чейки %d | %d, в новую €чейку %d | %d\n",
//                        cell.getX(), cell.getY(), newX, newY);

                    boolean isMove = true;
                    if (newX >= GameField.getColX() || newY >= GameField.getRowY() || newX < 0 || newY < 0) {
             
                        System.out.printf("%s ќбъект пытаетс€ убежать из €чейки %d | %d, в новую €чейку %d | %d ---> ",
                                nextUnit, cell.getX(), cell.getY(), newX, newY);
                        System.out.println("ѕровалено - выход за пределы пол€");
                    } else if (newX == cell.getX() && newY == cell.getY()) {

                        System.out.printf("%s ќбъект пытаетс€ убежать из €чейки %d | %d, в новую €чейку %d | %d ---> ",
                                nextUnit, cell.getX(), cell.getY(), newX, newY);
                        System.out.println("ѕровалено - та же €чейка");
                    } else {
                        Cell cellTarget = getField()[newY][newX];
                        int numberOfOneTypeOfUnitsInNewCell = cellTarget.getSetUnitsInCell(unitsName).size();
                        if (numberOfOneTypeOfUnitsInNewCell >= maxUnitsInCell) {
                            System.out.printf("%s ќбъект пытаетс€ убежать из €чейки %d | %d, в новую €чейку %d | %d ---> ",
                                    nextUnit, cell.getX(), cell.getY(), newX, newY);
                            System.out.println("ѕровалено - €чейка перенаселена");
                            isMove = false;
                        }
                        if (isMove) {
                            System.out.printf("ќбъект пытаетс€ убежать из €чейки %d | %d, в новую €чейку %d | %d ---> ",
                                    cell.getX(), cell.getY(), newX, newY);
                            System.out.println("ѕеремещение успешно ~~~~~");

                        }

                    }
                }


            } else {
                System.out.println("трава не бегает");
            }


        }


    }
}




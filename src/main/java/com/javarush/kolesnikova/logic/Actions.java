package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.field.GameField;
import com.javarush.kolesnikova.entities.units.Animals;
import com.javarush.kolesnikova.entities.units.Plants;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.entities.units.carnivorous.Carnivore;
import com.javarush.kolesnikova.entities.units.herbivores.Herbivore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.kolesnikova.constants.PropertiesUnit.chanceToHaveDinner;
import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;
import static com.javarush.kolesnikova.utils.Utils.getRandom;


public class Actions {


    public static void actions() {
        getCellsStat();
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                for (UnitsName name : cell.getUnitsInCell().keySet()) {
                    multiply(cell, name);
                }
            }
        }
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                for (UnitsName name : cell.getUnitsInCell().keySet()) {
                    running(cell, name);
                }
            }
        }
        eating();
    }

    private static void eating() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                int[][] ints = chanceToHaveDinner();
                for (UnitsName name : cell.getUnitsInCell().keySet()) { // беру значение из ячейки
                    Set<Unit> cSet = cell.getSetUnitsInCell(name); // получаю повалку объектов хищников
                    if (getUnit(name) instanceof Carnivore && !cSet.isEmpty()) {   // ищу хищника
                        dinnerForCarnivore(cell, ints, name, cSet);
                    } else if (getUnit(name) instanceof Herbivore) { // ищу травоядных
                        dinnerForHerbivores(cell, cSet);

                    }
                }
            }
        }
    }

    private static void dinnerForHerbivores(Cell cell, Set<Unit> cSet) {
        for (Unit hUnit : cSet) {
            for (UnitsName p : cell.getUnitsInCell().keySet()) { // ищу травоядных
                Set<Unit> pSet = cell.getSetUnitsInCell(p);

                if (getUnit(p) instanceof Plants) {
                    boolean isEat = !pSet.isEmpty();
                    double soak = 0;
                    if (isEat) {
                        HashSet<Unit> pSetCopy = new HashSet<>(pSet);
                        for (Unit pUnit : pSetCopy) {
                            if (soak >= 0) {
                                System.out.printf("В %d|%d %s\n->%s = TRUE\n",
                                        cell.getX(), cell.getY(), hUnit, p);
                                double w;
                                if (pUnit.getWeight() >= hUnit.getKilogramOfFood()) {
                                    w = hUnit.getKilogramOfFood();
                                } else {
                                    w = pUnit.getWeight();
                                }
                                soak = soak + w;

                            }
                            hUnit.setWeight(hUnit.getWeight() + soak);
                            pSet.remove(pUnit);
                        }
                    } else  { // todo поправить баг с тем что животное даже если поест теряет часть жизни
                        double w = hUnit.getWeight() - hUnit.getKilogramOfFood() / 2;
                        hUnit.setWeight(w);
                        boolean isDeath = hUnit.getWeight() <= 0;
                        if (isDeath) {
                            cSet.remove(hUnit);
                            System.out.printf("В %d|%d %s\n-> = isDeath\n",
                                    cell.getX(), cell.getY(), hUnit);
                        }
                        System.out.printf("В %d|%d %s\n-> FALSE\n",
                                cell.getX(), cell.getY(), hUnit);
                    }
                }
            }
        }

    }


    private static void dinnerForCarnivore(Cell cell, int[][] ints, UnitsName uc, Set<Unit> ucSet) {
        for (Unit cUnit : ucSet) {
            for (UnitsName h : cell.getUnitsInCell().keySet()) { // ищу травоядных
                Set<Unit> hSet = cell.getSetUnitsInCell(h);
                if (getUnit(h) instanceof Herbivore && !hSet.isEmpty()) {
                    int chance = ints[uc.ordinal()][h.ordinal()] / 10;  // беру шанс поедания
                    int random = getRandom(10); // беру случайное число от 0 до 100
                    boolean isEat = chance > random;
                    Unit hUnit = hSet.iterator().next();
                    if (isEat) {
                        System.out.printf("В %d|%d %s\n->%s %d/%d = TRUE\n",
                                cell.getX(), cell.getY(), cUnit, hUnit, random, chance);
                        double w;
                        if (hUnit.getWeight() >= cUnit.getKilogramOfFood()) {
                            w = cUnit.getKilogramOfFood();
                        } else {
                            w = hUnit.getWeight();
                        }
                        cUnit.setWeight(cUnit.getWeight() + w);
                        hSet.remove(hUnit);
                    } else {
                        double w = cUnit.getWeight() - cUnit.getKilogramOfFood() / 2;
                        cUnit.setWeight(w);
                        boolean isDeath = cUnit.getWeight() <= 0;
                        if (isDeath) {
                            ucSet.remove(cUnit);
                            System.out.printf("В %d|%d %s\n->%s %d/%d = isDeath\n",
                                    cell.getX(), cell.getY(), cUnit, hUnit, random, chance);
                        }
                        System.out.printf("В %d|%d %s\n->%s %d/%d = FALSE\n",
                                cell.getX(), cell.getY(), cUnit, hUnit, random, chance);
                    }
                }
            }
        }
    }


    private static void getCellsStat() {
        HashMap<UnitsName, Integer> mapStatistic = new HashMap<>();
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
            System.out.printf("%s %s = %d\n",
                    getUnit(name).getIcon(), getUnit(name).getName(), mapStatistic.get(name));
        }


    }


    private static void multiply(Cell cell, UnitsName name) {
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
            System.out.printf("В %d|%d - %d %s. Рождено %d. Всего %d/%d\n",
                    cell.getX(), cell.getY(), numberOfOneTypeOfUnits, name, numberOfNewUnitsResult,
                    cell.getUnitsInCell().get(name).size(), maxUnitsInCell);


        } else {
            int numberOfNewUnitsResult = maxUnitsInCell - numberOfOneTypeOfUnits;
            for (int i = 0; i < numberOfNewUnitsResult; i++) {
                units.add(getUnit(name).clone());
            }
            System.out.printf("В %d|%d - %d %s. Выросло %d. Всего %d/%d\n",
                    cell.getX(), cell.getY(), numberOfOneTypeOfUnits, name, numberOfNewUnitsResult,
                    cell.getUnitsInCell().get(name).size(), maxUnitsInCell);
        }
    }


    private static void running(Cell cell, UnitsName name) {
        Set<Unit> units = cell.getSetUnitsInCell(name);
        HashSet<Unit> unitsCopy = new HashSet<>(units);
        if (getUnit(name) instanceof Animals) {
            for (Unit nextUnit : unitsCopy) {
                int maxUnitsInCell = nextUnit.getMaxUnitsInCell();
                int[] one = new int[]{-1, 1};
                int takeOne = getRandom(1);
                int newX = cell.getX() + (getRandom(nextUnit.getSpeed()) * one[takeOne]);
                int newY = cell.getY() + (getRandom(nextUnit.getSpeed()) * one[takeOne]);

                if (newX < 0) {
                    newX *= -1;
                }
                if (newY < 0) {
                    newY *= -1;
                }

                boolean isMove = true;
                System.out.printf("%s %d|%d в %d|%d = ", units.iterator().next().getName(), cell.getX(), cell.getY(), newX, newY);

                if (newX >= GameField.getColX() || newY >= GameField.getRowY() || newX < 0 || newY < 0) {
                    System.out.println("FALSE | выход за пределы поля");
                } else if (newX == cell.getX() && newY == cell.getY()) {
                    System.out.println("FALSE | та же ячейка");
                } else {
                    Cell cellTarget = getField()[newY][newX];
                    Set<Unit> setUnitsInCellTarget = cellTarget.getSetUnitsInCell(name);
                    int numberOfOneTypeOfUnitsInNewCell = setUnitsInCellTarget.size();
                    if (numberOfOneTypeOfUnitsInNewCell >= maxUnitsInCell) {
                        System.out.println("FALSE | перенаселение");
                        isMove = false;
                    }
                    if (isMove) {
                        System.out.println("TRUE | успешно");
                        setUnitsInCellTarget.add(nextUnit.clone());
                        units.remove(nextUnit);
                    }

                }
            }
        }
    }


}





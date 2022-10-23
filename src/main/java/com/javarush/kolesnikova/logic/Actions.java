package com.javarush.kolesnikova.logic;

import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.field.GameField;
import com.javarush.kolesnikova.entities.units.Animals;
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

    private static final HashMap<UnitsName, Integer> map = new HashMap<>();


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


    }


    //получить информацию о животных в яейке.
    // если это хищник то пытаемся съесть жавотное из той же клетки
    // если это травоядное  то пытаемся съесть траву из той же клетки
    // если вес животного равен 0 то умирает

    private static void eating() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                int[][] ints = chanceToHaveDinner();
                for (UnitsName name : cell.getUnitsInCell().keySet()) { // беру значение из ячейки
                    if (getUnit(name) instanceof Carnivore) {   // ищу хищника
                        Set<Unit> units = cell.getSetUnitsInCell(name); // получаю повалку объектов хищников
                        boolean isEat = false;
                        for (UnitsName uh : cell.getUnitsInCell().keySet()) { // ищу травоядных
                            if (getUnit(uh) instanceof Herbivore) {
                                int chance = ints[name.ordinal()][uh.ordinal()];  // ищу шанс поедания
                                int random = getRandom(100); // беру случайное число от 0 до 100
                                if (chance > random) {
                                    isEat = true;  // хищник съедает жертву
                                    // прибавляется вес у  хищника
                                    // жертва умирает
                                } else {
                                    // отнимается треть сут. нормы от веса хащника
                                    // если вес равен 0 то хищник умирает
                                }


                            } else if (getUnit(name) instanceof Herbivore) {

                            }
                        }
                    }
                }
            }
        }

}

    private static void getCellsStat() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                for (UnitsName name : cell.getUnitsInCell().keySet()) {
                    Set<Unit> setUnitsInCell = cell.getSetUnitsInCell(name);
                    int size = setUnitsInCell.size();
                    if (map.containsKey(name) && map.get(name) > 0) {
                        int i = map.get(name) + (Integer) size;
                        map.put(name, i);
                    } else {
                        map.put(name, size);
                    }
                }
            }
        }
        for (UnitsName name : map.keySet()) {
            System.out.printf("%s %s = %d\n",
                    getUnit(name).getIcon(), getUnit(name).getName(), map.get(name));
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





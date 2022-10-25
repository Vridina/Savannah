package com.javarush.kolesnikova.actions;


import com.javarush.kolesnikova.constants.PropertiesUnit;
import com.javarush.kolesnikova.entities.field.Cell;
import com.javarush.kolesnikova.entities.units.Plants;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.entities.units.carnivorous.Carnivore;
import com.javarush.kolesnikova.entities.units.herbivores.Herbivore;

import java.util.HashSet;
import java.util.Set;

import static com.javarush.kolesnikova.constants.PropertiesUnit.chanceToHaveDinner;
import static com.javarush.kolesnikova.entities.field.GameField.*;
import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;
import static com.javarush.kolesnikova.utils.Utils.getRandom;


public interface Eating {
//    void eating();


  static void eat() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                int[][] ints = chanceToHaveDinner();
                for (PropertiesUnit.UnitsName name : cell.getUnitsInCell().keySet()) { // беру значение из ячейки
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
            for (PropertiesUnit.UnitsName p : cell.getUnitsInCell().keySet()) {         // ищу травоядных
                Set<Unit> pSet = cell.getSetUnitsInCell(p);
                if (getUnit(p) instanceof Plants) {
                    boolean isEat = !pSet.isEmpty();
                    double soak = 0;
                    if (isEat) {
                        HashSet<Unit> pSetCopy = new HashSet<>(pSet);
                        for (Unit pUnit : pSetCopy) {
                            if (soak <= hUnit.getKilogramOfFood()) {
                                System.out.printf("В %d|%d %s\n->%s = TRUE\n",
                                        cell.getX(), cell.getY(), hUnit, p);
                                double w;
                                if (pUnit.getWeight() >= hUnit.getKilogramOfFood()) {   // вес жертвы больше или равно кол-во нужному насыщению то
                                    w = hUnit.getKilogramOfFood();                      //  берем вес нужный для насыщения
                                } else {
                                    w = pUnit.getWeight();                              // иначе берем весь вес жертвы
                                }
                                soak = soak + w;
                            }
                            pSet.remove(pUnit);
                        }
                        hUnit.setWeight(hUnit.getWeight() + soak);
                    } else {
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


    private static void dinnerForCarnivore(Cell cell, int[][] ints, PropertiesUnit.UnitsName uc, Set<Unit> ucSet) {
        for (Unit cUnit : ucSet) {
            for (PropertiesUnit.UnitsName h : cell.getUnitsInCell().keySet()) { // ищу травоядных
                Set<Unit> hSet = cell.getSetUnitsInCell(h);
                if (getUnit(h) instanceof Herbivore && !hSet.isEmpty()) {
                    int chance = ints[uc.ordinal()][h.ordinal()] / 10;  // беру шанс поедания
                                                                      // todo если шанс равен 0 то пропускать такой шанс
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


}

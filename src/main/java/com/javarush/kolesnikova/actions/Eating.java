package com.javarush.kolesnikova.actions;


import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
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
    int[][] CHANCE = chanceToHaveDinner();

    static void eat() {
        Cell[][] field = getField();
        for (int y = 0; y < getRowY(); y++) {
            for (int x = 0; x < getColX(); x++) {
                Cell cell = field[y][x];
                for (UnitsName type : cell.getUnitsInCell().keySet()) {
                    if (getUnit(type) instanceof Carnivore) {
                        dinnerForCarnivore(cell, type);
                    } else if (getUnit(type) instanceof Herbivore) {
                        dinnerForHerbivores(cell, type);
                    }
                }
            }
        }
    }

    private static void dinnerForHerbivores(Cell cell, UnitsName type) {
        Set<Unit> unitsSet = cell.getSetUnitsInCell(type);
        for (Unit unit : unitsSet) {
            for (UnitsName victimType : cell.getUnitsInCell().keySet()) {
                Set<Unit> pSet = cell.getSetUnitsInCell(victimType);
                int chance1 = CHANCE[type.ordinal()][victimType.ordinal()] / 10;

//                if (chance1 > 0) {
                if (getUnit(victimType) instanceof Plants) {
                    boolean isEat = !pSet.isEmpty();
                    double soak = 0;
                    if (isEat) {
                        HashSet<Unit> pSetCopy = new HashSet<>(pSet);
                        for (Unit pUnit : pSetCopy) {
                            if (soak <= unit.getKilogramOfFood()) {
//                                System.out.printf("?? %d|%d %s\n->%s = TRUE\n",
//                                        cell.getX(), cell.getY(), unit, victimType);
                                double w;
                                if (pUnit.getWeight() >= unit.getKilogramOfFood()) {
                                    w = unit.getKilogramOfFood();
                                } else {
                                    w = pUnit.getWeight();
                                }
                                soak = soak + w;
                            }
                            pSet.remove(pUnit);
                        }
                        unit.setWeight(unit.getWeight() + soak);
                    } else {
                        double w = unit.getWeight() - unit.getKilogramOfFood() / 2;
                        unit.setWeight(w);
                        boolean isDeath = unit.getWeight() <= 0;
                        if (isDeath) {
                            unitsSet.remove(unit);
//                            System.out.printf("?? %d|%d %s\n-> = isDeath\n",
//                                    cell.getX(), cell.getY(), unit);
                        }
//                        System.out.printf("?? %d|%d %s\n-> FALSE\n",
//                                cell.getX(), cell.getY(), unit);
                    }

                }
            }
        }

    }


    private static void dinnerForCarnivore(Cell cell, UnitsName type) {

        Set<Unit> unitsSet = cell.getSetUnitsInCell(type);
        HashSet<Unit> unitsSetCopy = new HashSet<>(unitsSet);
        for (Unit unit : unitsSetCopy) {                                  // ?????????? ?????????????????????? ??????????-??????????????

            boolean isDeath = unit.getWeight() <= 0;  //  ???????? ?????? ???????????? ?????? ?????????? 0 ????
            if (isDeath) {   //  ???????? ??????????????
//                System.out.println(unit.getId() + " ???????? " + unit.getName() + " " + unit.getWeight() + " ");
                unitsSet.remove(unit);
            }
            for (UnitsName victimType : cell.getUnitsInCell().keySet()) { // ?????????????????? ???????????????? ?? ????????????

                boolean isEatable = CHANCE[type.ordinal()][victimType.ordinal()] > 0; //?????? ??????????????????
                Set<Unit> victimSet = cell.getSetUnitsInCell(victimType);


                if (isEatable && !victimSet.isEmpty()) {           //???????? ?????????? ??????????????????, ?? ?????? ???? ???????????? ????
                    //???????????????? ???????? ????????????????  
                    boolean isEat = CHANCE[type.ordinal()][victimType.ordinal()] / 10 > getRandom(10);
                    double diet;     // ??????
                    if (isEat) {  //  ???? :
                        Unit victimUnit = victimSet.iterator().next(); // ????????1 ??????????

//                        System.out.printf("?? %d|%d %s\n->%s %d/%d = TRUE\n",
//                                cell.getX(), cell.getY(), unit, victimUnit, random, chance);

                        if (victimUnit.getWeight() >= unit.getKilogramOfFood()) { // ???????? ?????? ????????????  >= ???????????? ??????-???? ???????????????? ?????? ?????????????????? ????
                            diet = unit.getKilogramOfFood();  // ?????????????????? ?? diet ???????? ??????
                        } else {
                            diet = victimUnit.getWeight(); // ?????????? ???????? ?????? ????????????
                        }
                        unit.setWeight(unit.getWeight() + diet);   // ???????????????? ?????????????????? ?? ????????????????
                        victimSet.remove(victimUnit); //  ???????????? ????????????

                    } else { // ???????? ?? ?? ???? :
                        diet = unit.getKilogramOfFood() / 2; //???????????? ???????????? ????????
                        unit.setWeight(unit.getWeight() - diet); // ?????????????? ??????
//                           System.out.printf("???????? - isDeath- ?? %d|%d %s\n->%s %d/%d = isDeath\n",
//                                   cell.getX(), cell.getY(), unit, hUnit, random, chance);
                    }
//                        System.out.printf("?? %d|%d %s\n->%s %d/%d = FALSE\n",
//                                cell.getX(), cell.getY(), unit, hUnit, random, chance);
                }
            }

        }
    }
}






        

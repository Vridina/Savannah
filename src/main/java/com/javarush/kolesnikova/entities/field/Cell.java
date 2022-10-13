package com.javarush.kolesnikova.entities.field;


import com.javarush.kolesnikova.entities.units.Unit;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;


public class Cell {

    private final int x;
    private final int y;

    // каждый тип юнитов - это отдельный поток, создаем сет юнитов
    private Set<Unit> unitsInCell = new HashSet<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

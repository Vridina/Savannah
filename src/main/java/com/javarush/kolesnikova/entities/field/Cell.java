package com.javarush.kolesnikova.entities.field;

import com.javarush.kolesnikova.entities.units.Unit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

   public Map<String, Set<Unit>> sets = new HashMap<>();


}

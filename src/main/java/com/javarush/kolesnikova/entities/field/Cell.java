package com.javarush.kolesnikova.entities.field;


import com.javarush.kolesnikova.entities.units.Unit;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Cell {

    private int x;
    private int y;

    private Set<Unit> unitsInCell;

    public Cell(int x, int y, Set<Unit> unitsInCell) {
        this.x = x;
        this.y = y;
        this.unitsInCell = unitsInCell;
        System.out.printf("Cоздана €чейка %d | %d в нее заселили: \n", x,y);
    }


}

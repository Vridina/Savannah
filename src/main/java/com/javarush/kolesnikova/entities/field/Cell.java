package com.javarush.kolesnikova.entities.field;

import com.javarush.kolesnikova.constants.PropertiesUnit.UnitsName;
import com.javarush.kolesnikova.entities.units.Unit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Set;

@Getter
@Setter
@ToString
public class Cell {

    private int x;
    private int y;


    private HashMap<UnitsName, Set<Unit>> unitsInCell;

    public Cell(int x, int y, HashMap<UnitsName, Set<Unit>> unitsInCell) {
        this.x = x;
        this.y = y;
        this.unitsInCell = unitsInCell;
        System.out.printf("\nCоздана €чейка %d | %d в нее заселили: ", x, y);
    }
}

package com.javarush.kolesnikova.entities.field;


import com.javarush.kolesnikova.entities.units.Unit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;

@Getter
@Setter
@ToString
public class Cell {

    private int x;
    private int y;

    private  HashSet<Unit> unitsInCell;


    public Cell(int x, int y, HashSet<Unit> unitsInCell) {
        this.x = x;
        this.y = y;
        this.unitsInCell = unitsInCell;
        System.out.printf("\nC������ ������ %d | %d � ��� ��������: ", x,y);
    }





}

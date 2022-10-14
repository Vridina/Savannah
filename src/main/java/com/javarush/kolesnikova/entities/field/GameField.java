package com.javarush.kolesnikova.entities.field;


public class GameField {

    private static final int rowY = 2;
    private static final int colX = 10;

    private static final Cell[][] field = new Cell[rowY][colX];

    public static int getRowY() {
        return rowY;
    }

    public static int getColX() {
        return colX;
    }

    public static Cell[][] getField() {
        return field;
    }


}

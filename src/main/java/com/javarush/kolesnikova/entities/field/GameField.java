package com.javarush.kolesnikova.entities.field;



public class GameField {

    private static final int row = 2;
    private static final int col = 10;


    private static final Cell[][] field = new Cell[row][col];

//  создание пол€ с €чейками, каждой €чейке присваиваютс€ координаты x и y.
    public static void createGame() {
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                field[y][x] = new Cell(x, y);
                System.out.print("-");
            }
            System.out.println("*");
        }
    }


}

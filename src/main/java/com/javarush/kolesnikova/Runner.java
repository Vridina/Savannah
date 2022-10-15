package com.javarush.kolesnikova;


import com.javarush.kolesnikova.constants.UnitsName;
import com.javarush.kolesnikova.controller.MainController;
import com.javarush.kolesnikova.entities.units.Unit;


import static com.javarush.kolesnikova.factory.UnitsFactory.getUnit;


public class Runner {

    public static void main(String[] args) {
        System.out.println("������.");



        Unit wolf = getUnit(UnitsName.valueOf("WOLF"));
        wolf.run();
//        wolf.toString();
        Unit cloneWolf = wolf.clone();


        System.out.println(wolf.getId());
        System.out.println("��������� ������ - "+((UnitsName.values()).length));
        System.out.println("________________________");


       MainController.startApp();

        System.out.println("________________________");


    }


}

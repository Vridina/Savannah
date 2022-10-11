package com.javarush.kolesnikova;

import com.javarush.kolesnikova.entities.units.Animals;
import com.javarush.kolesnikova.entities.units.FactoryMethod;
import com.javarush.kolesnikova.entities.units.Unit;
import com.javarush.kolesnikova.entities.units.animals.herbivores.Herbivore;
import com.javarush.kolesnikova.entities.units.unitsMaker.UnitMaker;

import static com.javarush.kolesnikova.entities.units.FactoryMethod.getUnitMaker;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Запуск.");

        Unit wolf = getUnitMaker("Wolf").makeUnit();
        Unit rabbit = getUnitMaker("Rabbit").makeUnit();

        wolf.eat((Herbivore) rabbit);
        System.out.print("Размножаемся:  ");
        wolf.multiply();
        wolf.run();

//
//        Herb herb = new Herb();
//        Wolf wolf = new Wolf();
//        Rabbit rabbit = new Rabbit();
//
//        herb.multiply();
//

//
//        rabbit.multiply();
//        rabbit.eat();
//        rabbit.run();
    }


}

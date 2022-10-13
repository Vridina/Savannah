package com.javarush.kolesnikova.entities.units.carnivorous;



import com.javarush.kolesnikova.entities.units.Animals;


 public abstract class Carnivore extends Animals {


  public Carnivore(String icon, String name, Double weight, int speed, int maxUnitsInCell, Double kilogramOfFood) {
   super(icon, name, weight, speed, maxUnitsInCell, kilogramOfFood);
  }
 }


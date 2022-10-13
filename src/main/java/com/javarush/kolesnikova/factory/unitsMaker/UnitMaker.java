package com.javarush.kolesnikova.factory.unitsMaker;

import com.javarush.kolesnikova.entities.units.Unit;

public abstract class UnitMaker  {
   Unit makeUnit() {
      return new Unit();
   }
}

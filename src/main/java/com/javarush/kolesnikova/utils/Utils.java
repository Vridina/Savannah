package com.javarush.kolesnikova.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {



    public static int getRandom(int maxUnitsInCell) {
        return ThreadLocalRandom.current().nextInt(0, maxUnitsInCell);
    }
}

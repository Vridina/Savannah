package com.javarush.kolesnikova.util;

import com.javarush.kolesnikova.exceptions.GameException;

import java.util.concurrent.ThreadLocalRandom;

class RandomNum extends Thread {


    private int result;

    public int randomNumbers(int start, int finish) {
        try {
            int result = ThreadLocalRandom.current().nextInt(start,finish);
        } catch (GameException e) {
            System.out.println("Exception");
        }
        return result;
    }
}



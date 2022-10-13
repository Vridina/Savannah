package com.javarush.kolesnikova.util;

import com.javarush.kolesnikova.exceptions.GameException;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers extends Thread {

    public static final int BOUND = 100;
    private int result;

    public int randomNumbers() {
        try {
            int result = ThreadLocalRandom.current().nextInt(BOUND);
        } catch (GameException e) {
            System.out.println("Exception");
        }
        return result;
    }
}



package com.javarush.island.bakhtin;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(ThreadLocalRandom.current().nextInt(1,4));
        }

    }
}

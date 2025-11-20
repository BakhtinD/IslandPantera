package com.javarush.island.bakhtin.animals;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Moveable {

    private int amountOfSteps;
    private int currentX;
    private int currentY;

    public void move() {
        for (int i = 0; i < amountOfSteps; i++) {
            int randX = ThreadLocalRandom.current().nextInt(2, 4);
            int randY = ThreadLocalRandom.current().nextInt(2, 4);
            while (randY == 3 & randX == 3) {
                randX = ThreadLocalRandom.current().nextInt(2, 4);
                randY = ThreadLocalRandom.current().nextInt(2, 4);
            }

            if (currentX > 0) {
                int newX = currentX - 1 + randX;
            } else {
                int newX = currentX + randX - 1; // currentX = 0
            }
            //TODO Дописать когда будет написана карта
            if (currentY > 0) {
                int newY = currentY - 1 + randY;
            } else {

            }
        }
    }
}

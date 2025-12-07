package com.javarush.island.bakhtin.animals;

import com.javarush.island.bakhtin.Point;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Data;

@Data
public abstract class Animal {

    private static String type;
    private static int counter;
    //todo вес в граммы
    private static int initialWeight;

    private int maxSpeed;
    private int weight;
    private int x;
    private int y;
    private int weightToGetFull;
    private int step;
    private int id;
    private ThreadLocalRandom random = ThreadLocalRandom.current();

    public int getInitialWeight() {
        return initialWeight;
    }

    public Animal() {
        this.id = counter++;
    }

    public abstract AnimalType getType();

    public Point getPointToMove(int maxX, int maxY) {
        int deltaX = random.nextInt(-1, 2);
        int deltaY = random.nextInt(-1, 2);
        x = x + (deltaX * maxSpeed);
        y = y + (deltaY * maxSpeed);
        if (x < 0) {
            x = 0;
        } else if (x >= maxX) {
            x = maxX - 1;
        }
        if (y < 0) {
            y = 0;
        } else if (y >= maxY) {
            y = maxY - 1;
        }
        return new Point(x, y);
    }

    public void decWeight() {
        setWeight(getWeight() - getInitialWeight()/10);
        //System.out.println(this + " похудел");
    }

    public void incSteps() {
        step++;
    }

    public void eat(int eatenWeight) {
        weight += eatenWeight;
    }
}

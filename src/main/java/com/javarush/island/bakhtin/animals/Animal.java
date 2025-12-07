package com.javarush.island.bakhtin.animals;

import com.javarush.island.bakhtin.Point;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Data;

@Data
public abstract class Animal {

    private int maxSpeed;
    private double weight;
    private int x;
    private int y;
    private double weightToGetFull;
    private static String type;
    private int step;
    private int id;
    private static int counter;

    public double getInitialWeight() {
        return initialWeight;
    }

    private static double initialWeight;

    public Animal() {
        this.id = counter++;
    }

    public abstract AnimalType getType();

    public Point getPointToMove(int maxX, int maxY) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int deltaX = random.nextInt(-1, 2);
        int deltaY = random.nextInt(-1, 2);
        x = x + deltaX * maxSpeed;
        y = y + deltaY * maxSpeed;
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
        //todo
        setWeight(getWeight() - getInitialWeight());
        //System.out.println(this + " похудел");
    }

    public void incSteps() {
        setStep(getStep() + 1);
    }

    public void eat(double eatenWeight) {
        setWeight(eatenWeight + getWeight());
    }
}

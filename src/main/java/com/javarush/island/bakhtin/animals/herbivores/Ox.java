package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Ox extends Animal {
    public static final AnimalType TYPE = AnimalType.OX;
    public static final double initialWeight = 700;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Ox() {
        setMaxSpeed(3);
        setWeight(initialWeight);
        setWeightToGetFull(100);
    }
}

package com.javarush.island.bakhtin.animals.predators;

import static com.javarush.island.bakhtin.animals.AnimalType.WOLF;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Wolf extends Animal {

    public static final AnimalType TYPE = WOLF;
    private static final double initialWeight = 50;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Wolf() {
        setMaxSpeed(3);
        setWeightToGetFull(8);
        setWeight(initialWeight);
    }

}

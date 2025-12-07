package com.javarush.island.bakhtin.animals.predators;

import static com.javarush.island.bakhtin.animals.AnimalType.WOLF;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Wolf extends Animal {

    public static final AnimalType TYPE = WOLF;
    private static final int initialWeight = 50000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Wolf() {
        setMaxSpeed(3);
        setWeightToGetFull(8000);
        setWeight(initialWeight);
    }

}

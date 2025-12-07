package com.javarush.island.bakhtin.animals.predators;

import static com.javarush.island.bakhtin.animals.AnimalType.EAGLE;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Eagle extends Animal {

    public static final AnimalType TYPE = EAGLE;
    public static final double initialWeight = 6;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Eagle() {
        setMaxSpeed(3);
        setWeightToGetFull(1);
        setWeight(initialWeight);
    }

}

package com.javarush.island.bakhtin.animals.predators;


import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Python extends Animal {

    public static final AnimalType TYPE = AnimalType.PYTHON;
    private static final double initialWeight = 15;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Python() {
        setMaxSpeed(1);
        setWeightToGetFull(3);
        setWeight(initialWeight);
    }

}

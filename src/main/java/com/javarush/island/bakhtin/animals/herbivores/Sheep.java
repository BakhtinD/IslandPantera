package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Sheep extends Animal {

    public static final AnimalType TYPE = AnimalType.SHEEP;
    public static final double initialWeight = 70;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Sheep() {
        setMaxSpeed(3);
        setWeight(initialWeight);
        setWeightToGetFull(15);
    }
}

package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Rabbit extends Animal {

    public static final AnimalType TYPE = AnimalType.RABBIT;
    public static final double initialWeight = 2;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Rabbit() {
        setMaxSpeed(2);
        setWeight(initialWeight);
        setWeightToGetFull(0.45);
    }


}

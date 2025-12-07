package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Mouse extends Animal {
    public static final AnimalType TYPE = AnimalType.MOUSE;
    public static final double initialWeight = 0.05;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Mouse() {
        setMaxSpeed(1);
        setWeight(initialWeight);
        setWeightToGetFull(0.01);
    }
}

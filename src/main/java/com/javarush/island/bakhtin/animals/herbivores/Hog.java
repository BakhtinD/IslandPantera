package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Hog extends Animal {

    public static final AnimalType TYPE = AnimalType.HOG;
    public static final int initialWeight = 400000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Hog() {
        setMaxSpeed(2);
        setWeight(initialWeight);
        setWeightToGetFull(50000);
    }
}

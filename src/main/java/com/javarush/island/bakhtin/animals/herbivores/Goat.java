package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Goat extends Animal {

    public static final AnimalType TYPE = AnimalType.GOAT;
    public static final int initialWeight = 60000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Goat() {
        setMaxSpeed(3);
        setWeight(initialWeight);
        setWeightToGetFull(10000);
    }

}

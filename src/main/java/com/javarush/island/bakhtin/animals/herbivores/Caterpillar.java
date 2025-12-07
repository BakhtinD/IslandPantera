package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Caterpillar extends Animal {
    public static final AnimalType TYPE = AnimalType.CATERPILLAR;
    public static final int initialWeight = 10;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Caterpillar() {
        setMaxSpeed(0);
        setWeight(initialWeight);
        setWeightToGetFull(0);
    }
}

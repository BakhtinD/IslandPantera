package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Dear extends Animal {

    public static final AnimalType TYPE = AnimalType.DEAR;
    public static final int initialWeight = 300000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Dear() {
        setMaxSpeed(4);
        setWeight(initialWeight);
        setWeightToGetFull(50000);
    }
}

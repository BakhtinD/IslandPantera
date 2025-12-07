package com.javarush.island.bakhtin.animals.predators;

import static com.javarush.island.bakhtin.animals.AnimalType.BEAR;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Bear extends Animal {

    public static final AnimalType TYPE = BEAR;
    public static final int initialWeight = 500000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Bear() {
        setMaxSpeed(2);
        setWeightToGetFull(80000);
        setWeight(initialWeight);
    }

}

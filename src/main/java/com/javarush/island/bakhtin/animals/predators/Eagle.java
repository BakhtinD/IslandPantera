package com.javarush.island.bakhtin.animals.predators;

import static com.javarush.island.bakhtin.animals.AnimalType.EAGLE;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Eagle extends Animal {

    public static final AnimalType TYPE = EAGLE;
    public static final int initialWeight = 6000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Eagle() {
        setMaxSpeed(3);
        setWeightToGetFull(1000);
        setWeight(initialWeight);
    }

}

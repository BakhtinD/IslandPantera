package com.javarush.island.bakhtin.animals.predators;

import static com.javarush.island.bakhtin.animals.AnimalType.FOX;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Fox extends Animal {

    public static final AnimalType TYPE = FOX;
    public static final int initialWeight = 8000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Fox() {
        setMaxSpeed(2);
        setWeightToGetFull(2000);
        setWeight(initialWeight);
    }

}

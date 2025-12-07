package com.javarush.island.bakhtin.animals.herbivores;

import static com.javarush.island.bakhtin.animals.AnimalType.DUCK;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Duck extends Animal {

    public static final AnimalType TYPE = DUCK;
    public static final int initialWeight = 1000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Duck() {
        setMaxSpeed(4);
        setWeightToGetFull(150);
        setWeight(initialWeight);
    }

}

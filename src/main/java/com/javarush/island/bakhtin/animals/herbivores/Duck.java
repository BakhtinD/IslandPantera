package com.javarush.island.bakhtin.animals.herbivores;

import static com.javarush.island.bakhtin.animals.AnimalType.DUCK;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Duck extends Animal {

    public static final AnimalType TYPE = DUCK;
    public static final double initialWeight = 1;

    public double getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Duck() {
        setMaxSpeed(4);
        setWeightToGetFull(0.15);
        setWeight(initialWeight);
    }

}

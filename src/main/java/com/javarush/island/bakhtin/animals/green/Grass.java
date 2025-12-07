package com.javarush.island.bakhtin.animals.green;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Grass extends Animal {

    public static final AnimalType TYPE = AnimalType.GRASS;
    public static final int initialWeight = 1000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    @Override
    public void decWeight() {

    }

    public Grass() {
        setMaxSpeed(1);
        setWeight(initialWeight);
    }

}

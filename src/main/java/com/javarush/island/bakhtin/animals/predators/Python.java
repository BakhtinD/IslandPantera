package com.javarush.island.bakhtin.animals.predators;


import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Python extends Animal {

    public static final AnimalType TYPE = AnimalType.PYTHON;
    private static final int initialWeight = 15000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Python() {
        setMaxSpeed(1);
        setWeightToGetFull(3000);
        setWeight(initialWeight);
    }

}

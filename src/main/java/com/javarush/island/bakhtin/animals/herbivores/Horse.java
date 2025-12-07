package com.javarush.island.bakhtin.animals.herbivores;


import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Horse extends Animal {


    public static final AnimalType TYPE = AnimalType.HORSE;
    public static final int initialWeight = 400000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }


    public Horse() {
        setMaxSpeed(4);
        setWeightToGetFull(60000);
        setWeight(initialWeight);
    }

}

package com.javarush.island.bakhtin.animals.herbivores;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;

public class Rabbit extends Animal {

    public static final AnimalType TYPE = AnimalType.RABBIT;
    public static final int initialWeight = 2000;

    public int getInitialWeight(){
        return initialWeight;
    }

    @Override
    public AnimalType getType() {
        return TYPE;
    }

    public Rabbit() {
        setMaxSpeed(2);
        setWeight(initialWeight);
        setWeightToGetFull(450);
    }


}

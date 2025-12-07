package com.javarush.island.bakhtin.animals;

import com.javarush.island.bakhtin.animals.green.Grass;
import com.javarush.island.bakhtin.animals.herbivores.*;
import com.javarush.island.bakhtin.animals.predators.*;

public enum NumOfAnimalsInPack {
    WOLF(30, Wolf.TYPE),
    RABBIT(150, Rabbit.TYPE),
    GRASS(200, Grass.TYPE),
    CATERPILLAR(1000, Caterpillar.TYPE),
    DEAR(20, Dear.TYPE),
    GOAT(140, Goat.TYPE),
    HORSE(20, Horse.TYPE),
    MOUSE(500, Mouse.TYPE),
    PYTHON(30, Python.TYPE),
    FOX(30, Fox.TYPE),
    BEAR(5, Bear.TYPE),
    EAGLE(20, Eagle.TYPE),
    HOG(50, Hog.TYPE),
    OX(10, Ox.TYPE),
    DUCK(200, Duck.TYPE),
    SHEEP(140, Sheep.TYPE)
    ;

    private final int value;
    private final AnimalType name;

    NumOfAnimalsInPack(int value, AnimalType name) {
        this.value = value;
        this.name = name;
    }

    public static int getValue(AnimalType name) {
        for (NumOfAnimalsInPack item : values()) {
            if (item.name == name) {
                return item.value;
            }
        }
        return 0;
    }
}

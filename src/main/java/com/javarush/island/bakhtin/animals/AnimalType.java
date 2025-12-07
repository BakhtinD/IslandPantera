package com.javarush.island.bakhtin.animals;

import com.javarush.island.bakhtin.animals.green.Grass;
import com.javarush.island.bakhtin.animals.herbivores.*;
import com.javarush.island.bakhtin.animals.predators.*;
import lombok.Getter;

public enum AnimalType {


    WOLF(false, Wolf.class),
    RABBIT(true, Rabbit.class),
    GRASS(false, Grass.class),
    DEAR(true, Dear.class),
    GOAT(true, Goat.class),
    HOG(true, Hog.class),
    MOUSE(true, Mouse.class),
    OX(true, Ox.class),
    SHEEP(true, Sheep.class),
    CATERPILLAR(true, Caterpillar.class),
    BEAR(false, Bear.class),
    DUCK(true, Duck.class),
    EAGLE(false, Eagle.class),
    FOX(false, Fox.class),
    HORSE(true, Horse.class),
    PYTHON(false, Python.class),
    ;

    @Getter
    private final boolean isHerbivore;
    @Getter
    private final Class<? extends Animal> animalClass;

    AnimalType(boolean isHerbivore,
            Class<? extends Animal> aClass) {
        this.isHerbivore = isHerbivore;
        this.animalClass = aClass;
    }


}

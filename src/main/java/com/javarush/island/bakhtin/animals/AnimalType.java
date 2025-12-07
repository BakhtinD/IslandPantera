package com.javarush.island.bakhtin.animals;

import com.javarush.island.bakhtin.animals.green.Grass;
import com.javarush.island.bakhtin.animals.herbivores.*;
import com.javarush.island.bakhtin.animals.predators.*;
import java.util.concurrent.ThreadLocalRandom;
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
            Class<? extends Animal> aClass) {// в конструктор класс положить todo
        this.isHerbivore = isHerbivore;
        this.animalClass = aClass;
    }

    public static AnimalType getRandomType() {
        var arrayWithTypes = AnimalType.values();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomNumber = random.nextInt(arrayWithTypes.length);
        return arrayWithTypes[randomNumber];
    }
}

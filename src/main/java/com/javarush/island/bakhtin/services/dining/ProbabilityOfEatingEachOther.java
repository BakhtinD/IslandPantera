package com.javarush.island.bakhtin.services.dining;

import com.javarush.island.bakhtin.animals.AnimalType;
import com.javarush.island.bakhtin.animals.green.Grass;
import com.javarush.island.bakhtin.animals.herbivores.*;
import com.javarush.island.bakhtin.animals.predators.*;

public enum ProbabilityOfEatingEachOther {

    WOLF_RABBIT(Wolf.TYPE, Rabbit.TYPE, 60),
    RABBIT_GRASS(Rabbit.TYPE, Grass.TYPE, 100),
    WOLF_HORSE(Wolf.TYPE, Horse.TYPE, 10),
    WOLF_DEAR(Wolf.TYPE, Dear.TYPE, 15),
    WOLF_MOUSE(Wolf.TYPE, Mouse.TYPE, 80),
    WOLF_GOAT(Wolf.TYPE, Goat.TYPE, 60),
    WOLF_SHEEP(Wolf.TYPE, Sheep.TYPE, 70),
    WOLF_HOG(Wolf.TYPE, Hog.TYPE, 15),
    WOLF_OX(Wolf.TYPE, Ox.TYPE, 10),
    WOLF_DUCK(Wolf.TYPE, Duck.TYPE, 40),
    PYTHON_FOX(Python.TYPE, Fox.TYPE, 15),
    PYTHON_RABBIT(Python.TYPE, Rabbit.TYPE, 20),
    PYTHON_MOUSE(Python.TYPE, Mouse.TYPE, 40),
    PYTHON_DUCK(Python.TYPE, Duck.TYPE, 10),
    FOX_RABBIT(Fox.TYPE, Rabbit.TYPE, 70),
    FOX_MOUSE(Fox.TYPE, Mouse.TYPE, 90),
    FOX_DUCK(Fox.TYPE, Duck.TYPE, 60),
    FOX_CATERPILLAR(Fox.TYPE, Caterpillar.TYPE, 40),
    BEAR_PYTHON(Bear.TYPE, Python.TYPE, 80),
    BEAR_HORSE(Bear.TYPE, Horse.TYPE, 40),
    BEAR_DEAR(Bear.TYPE, Dear.TYPE, 80),
    BEAR_RABBIT(Bear.TYPE, Rabbit.TYPE, 80),
    BEAR_MOUSE(Bear.TYPE, Mouse.TYPE, 90),
    BEAR_GOAT(Bear.TYPE, Goat.TYPE, 70),
    BEAR_SHEEP(Bear.TYPE, Sheep.TYPE, 70),
    BEAR_HOG(Bear.TYPE, Hog.TYPE, 50),
    BEAR_OX(Bear.TYPE, Ox.TYPE, 20),
    BEAR_DUCK(Bear.TYPE, Duck.TYPE, 10),
    EAGLE_FOX(Eagle.TYPE, Fox.TYPE, 10),
    EAGLE_RABBIT(Eagle.TYPE, Rabbit.TYPE, 90),
    EAGLE_MOUSE(Eagle.TYPE, Mouse.TYPE, 90),
    EAGLE_DUCK(Eagle.TYPE, Duck.TYPE, 80),

    ;

    ProbabilityOfEatingEachOther(AnimalType predator, AnimalType herbivore, int probability) {
        this.probability = probability;
        this.predator = predator;
        this.herbivore = herbivore;
    }

    private final int probability;
    private final AnimalType predator;
    private final AnimalType herbivore;

    static int getProbability(AnimalType predator, AnimalType herbivore) {
        if (predator.isHerbivore() && herbivore == Grass.TYPE){
            return 100;
        }
        for (ProbabilityOfEatingEachOther item : values()) {
            if (item.predator == predator && item.herbivore == herbivore) {
                return item.probability;
            }
        }
        return 0;
    }
}

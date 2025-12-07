package com.javarush.island.bakhtin.services.dining;

import com.javarush.island.bakhtin.Cell;
import com.javarush.island.bakhtin.animals.Animal;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DiningService {
    public final Random random = ThreadLocalRandom.current();

    public boolean eatEachOther(Cell cell) {
        List<Animal> listOfAnimalsInCell = cell.getListOfAnimalsInCell();

        for (Animal animal : listOfAnimalsInCell) {
            int eatenWeight = 0;
            int weightToGetFull = animal.getWeightToGetFull();
            for (Animal herbivore : listOfAnimalsInCell) {
                if (animal.getType() == herbivore.getType()) {
                    continue;
                }
                if (weightToGetFull <= eatenWeight) {
                    break;
                }

                boolean predatorEating = isPredatorEating(animal, herbivore);
                if (predatorEating) {
                    int rest = weightToGetFull - eatenWeight;
                    if (rest > herbivore.getWeight()){
                        cell.removeAnimalFromCell(herbivore);
                        eatenWeight += rest;
                    } else {
                        eatenWeight += herbivore.getWeight();
                        herbivore.setWeight(herbivore.getWeight() - rest);
                    }
                    //System.out.println(animal + " съел " + herbivore);
                }
            }
            animal.eat(eatenWeight);
        }
        return true;
    }

    private boolean isPredatorEating(Animal animal, Animal herbivore) {
        var prob = ProbabilityOfEatingEachOther.getProbability(animal.getType(),
                herbivore.getType());
        return random.nextInt(100) < prob;
    }
}

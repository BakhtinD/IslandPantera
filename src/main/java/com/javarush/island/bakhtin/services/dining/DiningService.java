package com.javarush.island.bakhtin.services.dining;

import com.javarush.island.bakhtin.Cell;
import com.javarush.island.bakhtin.animals.Animal;

import java.util.concurrent.ThreadLocalRandom;

public class DiningService {

    public boolean eatEachOther(Cell cell) {
        for (Animal animal : cell.getListOfAnimalsInCell()) {
            double eatenWeight = 0;
            double weightToGetFull = animal.getWeightToGetFull();
            for (Animal herbivore : cell.getListOfAnimalsInCell()) {
                if (animal.getType().equals(herbivore.getType())) {
                    continue;
                }
                if (weightToGetFull <= eatenWeight) {
                    break;
                }

                boolean predatorEating = isPredatorEating(animal, herbivore);
                if (predatorEating) {
                    double rest = weightToGetFull - eatenWeight;
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
        var random = ThreadLocalRandom.current().nextInt(100);
        return random < prob;
    }
}

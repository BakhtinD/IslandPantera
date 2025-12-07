package com.javarush.island.bakhtin.services;

import com.javarush.island.bakhtin.Cell;
import com.javarush.island.bakhtin.animals.Animal;

public class DyingService {

    public boolean buryCell(Cell cell) {
        for (Animal animal : cell.getListOfAnimalsInCell()) {
            if (animal.getWeight() <= animal.getInitialWeight()/5) {
                //System.out.println(animal + " умер от истощения");
                cell.removeAnimalFromCell(animal);
            //} else {
                //System.out.println(animal);
                //System.out.println(animal.getWeight());
            }
        }
        return true;
    }
}

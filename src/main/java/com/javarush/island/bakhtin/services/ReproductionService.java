package com.javarush.island.bakhtin.services;

import com.javarush.island.bakhtin.Cell;
import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;
import com.javarush.island.bakhtin.animals.NumOfAnimalsInPack;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ReproductionService {

    public boolean reproduce(Cell cell)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        for (AnimalType animalType : AnimalType.values()) {
            List<Animal> listOfAnimalsByType = cell.getListOfAnimalsByType(animalType);
            if (listOfAnimalsByType == null || listOfAnimalsByType.isEmpty()) {
                continue;
            }
            var firstAnimal = listOfAnimalsByType.getFirst();
            if (listOfAnimalsByType.size() < NumOfAnimalsInPack.getValue(animalType)) {
                for (int i = 0; i < listOfAnimalsByType.size() / 4; i++) {
                    Animal parent = listOfAnimalsByType.get(i);
                    parent.setWeight(parent.getWeight() / 1.25);
                    Animal animal = firstAnimal.getClass().getConstructor()
                            .newInstance();
                    cell.addAnimalsInCell(animal);
                    animal.setStep(firstAnimal.getStep());
                    animal.setX(firstAnimal.getX());
                    animal.setY(firstAnimal.getY());
                    animal.setWeight(firstAnimal.getWeight() / 2);
                    animal.setWeightToGetFull(firstAnimal.getWeightToGetFull());
                    //System.out.println(animal + " родился");
                }
            }
        }

        return true;
    }
}

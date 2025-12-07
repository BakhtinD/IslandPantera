package com.javarush.island.bakhtin;

import com.javarush.island.bakhtin.animals.Animal;

import com.javarush.island.bakhtin.animals.AnimalType;
import com.javarush.island.bakhtin.animals.NumOfAnimalsInPack;
import com.javarush.island.bakhtin.animals.green.Grass;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.SneakyThrows;

public class IslandPreparation {

    @SneakyThrows
    protected void spawnAnimals(IslandMap island) {
        for (int i = 0; i < island.getXSize(); i++) {
            for (int j = 0; j < island.getYSize(); j++) {
                Cell cell = new Cell(i, j);
//                AnimalType randomAnimal = AnimalType.getRandomType();
                for (AnimalType animal : AnimalType.values()) {
                    if (ThreadLocalRandom.current().nextBoolean() || animal.equals(Grass.TYPE)) {
                        int numOfAnimalsInPack = NumOfAnimalsInPack.getValue(
                                animal);
                        int numOfAnimalAtTheEnd = ThreadLocalRandom.current()
                                .nextInt(numOfAnimalsInPack);
                        List<? extends Animal> list = createMultipleAnimals(animal.getAnimalClass(),
                                numOfAnimalAtTheEnd);
                        for (Animal realAnimals : list) {
                            cell.addAnimalsInCell(realAnimals);
                        }
                    }
                }
                island.getMap().put(new Point(i, j), cell);
            }
        }
    }

    protected <T extends Animal> List<T> createMultipleAnimals(Class<T> animal, int num) {
        List<T> animals = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            try {
                T newAnimal = animal.getDeclaredConstructor().newInstance();
                animals.add(newAnimal);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return animals;
    }

}

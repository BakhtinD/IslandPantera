package com.javarush.island.bakhtin.services;

import com.javarush.island.bakhtin.Cell;
import com.javarush.island.bakhtin.IslandMap;
import com.javarush.island.bakhtin.Point;
import com.javarush.island.bakhtin.animals.Animal;

import com.javarush.island.bakhtin.animals.green.Grass;
import java.util.List;

public class MoveService {

    public boolean moveCell(IslandMap island, Cell startCell, int version) {
        List<Animal> listOfAnimalsByType = startCell.getListOfAnimalsInCell();

        if (listOfAnimalsByType == null || listOfAnimalsByType.isEmpty()) {
            return true;
        }

        for (Animal animal : listOfAnimalsByType) {
            if (animal.getStep() != version) {
                continue;
            }

            Point whereToMove = animal.getPointToMove(island.getXSize(), island.getYSize());
            //System.out.println(island.getXSize() + " " + island.getYSize());

            Cell cellToMove = island.getMap().get(whereToMove);
            safeMove(startCell, cellToMove, animal);
        }
        return true;
    }

    private synchronized void safeMove(Cell start, Cell finish, Animal animal) {
        if (!start.equals(finish)) {
            //todo переделать строчку ниже
            if (animal.getType() != Grass.TYPE) {
                start.removeAnimalFromCell(animal);
            }
            finish.addAnimalsInCell(animal);
/*
            System.out.println(animal + " перешел из " + start.getX() + "_" + start.getY() + " в "
                    + finish.getX() + "_" + finish.getY());
        } else {
            System.out.println("Прыжок на месте в координатах:" + start.getX() + ", " + start.getY()
                    + " выполненый " + animal);
*/
        }

        animal.decWeight();
        animal.incSteps();
    }
}



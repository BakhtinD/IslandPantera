package com.javarush.island.bakhtin;

import com.javarush.island.bakhtin.animals.Animal;
import com.javarush.island.bakhtin.animals.AnimalType;
import java.util.ArrayList;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Cell {

    private final int x;
    private final int y;

    private List<Animal> listOfAnimalsInCell = new CopyOnWriteArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Animal> getListOfAnimalsInCell() {
        return new ArrayList<>(listOfAnimalsInCell);
    }

    public List<Animal> getListOfAnimalsByType(AnimalType type) {
        return listOfAnimalsInCell.stream().filter(animal -> animal.getType() == type)
                .toList();
    }

    public long getCountByType(AnimalType type) {
        return listOfAnimalsInCell.stream().filter(animal -> animal.getType() == type)
                .count();
    }

    public void addAnimalsInCell(Animal animal) {
        //System.out.println("Добавление " + animal + " в ячейку "+ this.toDebugString());
        listOfAnimalsInCell.add(animal);
    }

    public void removeAnimalFromCell(Animal animal) {
        //System.out.println("Удаление " + animal + " из ячейки "+ this.toDebugString());
        listOfAnimalsInCell.remove(animal);
    }

    @Override
    public String toString() {

        StringBuilder resultString = new StringBuilder("[");
        for (AnimalType animalType : AnimalType.values()) {
            long countByType = getCountByType(animalType);
            resultString.append(" ").append(animalType.toString().charAt(0)).append(animalType.toString().charAt(1)).append("=")
                    .append(countByType)
                    .append(";");
        }
        resultString.append("] ");
        return resultString.toString();
    }

    public String toDebugString() {
        return this.getX() + "," + getY() + " " + listOfAnimalsInCell.toString();
    }
}

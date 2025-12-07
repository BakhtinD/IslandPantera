package com.javarush.island.bakhtin.services;

import com.javarush.island.bakhtin.Cell;
import com.javarush.island.bakhtin.IslandMap;
import com.javarush.island.bakhtin.Point;

public class PrinterService {

    public void printMap(IslandMap map) {
        for (int i = 0; i < map.getXSize(); i++) {
            for (int j = 0; j < map.getYSize(); j++) {
                Cell cell = map.getMap().get(new Point(i, j));
                System.out.print(cell);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}

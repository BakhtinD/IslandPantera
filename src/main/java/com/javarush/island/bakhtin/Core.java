package com.javarush.island.bakhtin;

import com.javarush.island.bakhtin.services.*;
import com.javarush.island.bakhtin.services.dining.DiningService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Core extends Thread {

    private PrinterService mapPrinter = new PrinterService();
    private MoveService moveService = new MoveService();
    private DiningService diningService = new DiningService();
    private IslandMap map;
    private DyingService dyingService = new DyingService();
    private ReproductionService reproductionService = new ReproductionService();
    private int v = 0;


    public Core(IslandMap islandMap) {
        this.map = islandMap;
    }

    public void run() {

        try (var eS = Executors.newFixedThreadPool(8)) {
            List<Callable<Boolean>> moveTasks = new ArrayList<>();
            List<Callable<Boolean>> diningTasks = new ArrayList<>();
            List<Callable<Boolean>> dyingTasks = new ArrayList<>();
            List<Callable<Boolean>> reproductionTasks = new ArrayList<>();
            for (int i = 0; i < map.getXSize(); i++) {
                for (int j = 0; j < map.getYSize(); j++) {
                    Cell cell = map.getMap().get(new Point(i, j));
                    moveTasks.add(() -> moveService.moveCell(map, cell, v));
                    diningTasks.add(() -> diningService.eatEachOther(cell));
                    dyingTasks.add(() -> dyingService.buryCell(cell));
                    reproductionTasks.add(() -> reproductionService.reproduce(cell));
                }
            }
            eS.invokeAll(moveTasks);
            eS.invokeAll(diningTasks);
            eS.invokeAll(dyingTasks);
            eS.invokeAll(reproductionTasks);
            v = v + 1;
            mapPrinter.printMap(map);
            System.out.println("Начался новый день");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

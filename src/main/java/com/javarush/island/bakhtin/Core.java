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
        long t = System.currentTimeMillis();
        try (var es = Executors.newFixedThreadPool(8)) {
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
            System.out.println("t1, ms: " + (System.currentTimeMillis() - t));
            es.invokeAll(moveTasks);
            System.out.println("t2, ms: " + (System.currentTimeMillis() - t));
            es.invokeAll(diningTasks);
            System.out.println("t3, ms: " + (System.currentTimeMillis() - t));
            es.invokeAll(dyingTasks);
            System.out.println("t4, ms: " + (System.currentTimeMillis() - t));
            es.invokeAll(reproductionTasks);
            System.out.println("t5, ms: " + (System.currentTimeMillis() - t));

            v = v + 1;
            mapPrinter.printMap(map);
            System.out.println("t6, ms: " + (System.currentTimeMillis() - t));
            System.out.println("Начался новый день");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
/*
        t1, ms: 0
        t2, ms: 765
        t3, ms: 2272
        t4, ms: 2312
        t1, ms: 0
        t2, ms: 855
        t3, ms: 4010
        t4, ms: 4031
        t1, ms: 0
        t2, ms: 786
        t3, ms: 1027
        t4, ms: 1054
        t1, ms: 9
        t2, ms: 724
        t3, ms: 917
        t4, ms: 952
        t5, ms: 1153
*/

    }
}

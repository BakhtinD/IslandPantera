package com.javarush.island.bakhtin;

import com.javarush.island.bakhtin.services.PrinterService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.Getter;

import java.util.*;
import lombok.SneakyThrows;

@Getter
public class Life {

    @SneakyThrows
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер X острова:");
        int xSizeOfTheMap = scanner.nextInt();
        System.out.println("Введите размер Y острова: ");
        int ySizeOfTheMap = scanner.nextInt();

        IslandMap islandMap = new IslandMap(xSizeOfTheMap, ySizeOfTheMap);
        IslandPreparation preparationService = new IslandPreparation();
        preparationService.spawnAnimals(islandMap);

        Core core = new Core(islandMap);
        PrinterService printerService = new PrinterService();
        printerService.printMap(islandMap);

        var threadPool = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        threadPool.scheduleAtFixedRate(core, 0, 1, TimeUnit.SECONDS);
    }


}

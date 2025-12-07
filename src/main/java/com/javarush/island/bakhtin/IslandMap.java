package com.javarush.island.bakhtin;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;

@Data
public class IslandMap {

    private ConcurrentHashMap<Point, Cell> map;
    private int xSize;
    private int ySize;

    public IslandMap(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        map = new ConcurrentHashMap<>();
    }
}

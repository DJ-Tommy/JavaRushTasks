package com.javarush.task.task35.task3513;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Tile {
    int value;

    public Tile() {
        this.value = 0;
    }

    public Tile(int value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public Color getFontColor() {
        return value < 16 ? new Color(0x776e65) : new Color(0xf9f6f2);
    }

    public Color getTileColor() {
        Map<Integer, Integer> mapTileColor = new HashMap<>();
        mapTileColor.put(0, 0xcdc1b4);
        mapTileColor.put(2, 0xeee4da);
        mapTileColor.put(4, 0xede0c8);
        mapTileColor.put(8, 0xf2b179);
        mapTileColor.put(16, 0xf59563);
        mapTileColor.put(32, 0xf67c5f);
        mapTileColor.put(64, 0xf65e3b);
        mapTileColor.put(128, 0xedcf72);
        mapTileColor.put(256, 0xedcc61);
        mapTileColor.put(512, 0xedc850);
        mapTileColor.put(1024, 0xedc53f);
        mapTileColor.put(2048, 0xedc22e);
        if (mapTileColor.containsKey(value)) {
            return new Color(mapTileColor.get(value));
        } else {
            return new Color(0xff0000);
        }
    }
}

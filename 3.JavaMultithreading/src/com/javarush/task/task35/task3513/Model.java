package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH * FIELD_WIDTH; i++) {
            gameTiles[i / FIELD_WIDTH][i % FIELD_WIDTH] = new Tile();
        }
        addTile();
        addTile();
    }

    private void print() {
        for (int i = 0; i < FIELD_WIDTH * FIELD_WIDTH; i++) {
            if (i % FIELD_WIDTH == 0) {
                System.out.println();
            }
            System.out.print(gameTiles[i / FIELD_WIDTH][i % FIELD_WIDTH] + " ");
        }
        System.out.println();
        System.out.println();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH * FIELD_WIDTH; i++) {
            if (gameTiles[i / FIELD_WIDTH][i % FIELD_WIDTH].isEmpty()) {
                tiles.add(gameTiles[i / FIELD_WIDTH][i % FIELD_WIDTH]);
            }
        }
        return tiles;
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles.size() < 1) {
            return;
        }
        tiles.get((int) (getEmptyTiles().size() * Math.random())).value = Math.random() < 0.9 ? 2 : 4;
    }
}

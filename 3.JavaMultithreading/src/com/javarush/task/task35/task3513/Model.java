package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    int score = 0;
    int maxTile = 0;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH * FIELD_WIDTH; i++) {
            gameTiles[i / FIELD_WIDTH][i % FIELD_WIDTH] = new Tile();
        }
//        print();
//        addTile();
//        addTile();
//        addTile();
//        addTile();
        addTile();
        addTile();
//        print();
//        compressTiles(gameTiles[0]);
//        compressTiles(gameTiles[1]);
//        compressTiles(gameTiles[2]);
//        compressTiles(gameTiles[3]);
//        print();
    }

    private void print() {
        for (int i = 0; i < FIELD_WIDTH * FIELD_WIDTH; i++) {
            if (i != 0 && i % FIELD_WIDTH == 0) {
                System.out.println();
            }
            System.out.print(gameTiles[i / FIELD_WIDTH][i % FIELD_WIDTH] + "  ");

        }
        System.out.println();
        System.out.println();
    }

    public void left() {
        boolean changing = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                changing = true;
            }
        }
        if (changing) {
            addTile();
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean changing = false;
        for (int i = tiles.length - 2; i >= 0; i--) {
            for (int j = i; j < tiles.length - 1; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    changing = true;
                    Tile tile = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = tile;
                }
            }
        }
        return changing;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean changing = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == 0) {
                return changing;
            }
            if (tiles[i].value == tiles[i + 1].value) {
                changing = true;
                tiles[i].value *= 2;
                score += tiles[i].value;
                if (maxTile < tiles[i].value) {
                    maxTile = tiles[i].value;
                }
                tiles[i + 1].value = 0;
                i++;
            }
        }
        compressTiles(tiles);
        return changing;
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
        int random = Math.random() < 0.9 ? 2 : 4;
        tiles.get((int) (getEmptyTiles().size() * Math.random())).value = random;
    }
}

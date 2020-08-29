package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 4;
    public int score = 0;
    public int maxTile = 0;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (previousStates.isEmpty() || previousScores.isEmpty()) {
            return;
        }
        score = previousScores.pop();
        gameTiles = previousStates.pop();


    }

    void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH * FIELD_WIDTH; i++) {
            gameTiles[i / FIELD_WIDTH][i % FIELD_WIDTH] = new Tile();
        }
//        test();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    return true;
                }
                if (i < FIELD_WIDTH - 2 && gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
                if (j < FIELD_WIDTH - 2 && gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private void test() {
        for (int i = 0; i < FIELD_WIDTH * FIELD_WIDTH / 2; i++) {
            addTile();
        }
        print();
        left();
        print();
        right();
        print();
        up();
        print();
        down();
        print();
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
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

    private void rotate() {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = gameTiles[i][j];
            }
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = tempTiles[FIELD_WIDTH - j - 1][i];
            }
        }
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean changing = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                changing = true;
            }
        }
        if (changing) {
            addTile();
        }
        isSaveNeeded = true;
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
//        int random = (int) (Math.random() * 10);
        tiles.get((int) (getEmptyTiles().size() * Math.random())).value = random;
    }
}

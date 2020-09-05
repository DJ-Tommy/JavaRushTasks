package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Move, Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public void move() {

    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        if (this.numberOfEmptyTiles != o.numberOfEmptyTiles) {
            return Integer.compare(this.numberOfEmptyTiles, o.numberOfEmptyTiles);
        }
        if (this.score != o.score) {
            return Integer.compare(this.score, o.score);
        }
        return 0;
    }
}

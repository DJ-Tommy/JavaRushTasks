package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private static int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public View getView() {
        return view;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT && !view.isGameLost && !view.isGameWon) {
            model.left();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !view.isGameLost && !view.isGameWon) {
            model.right();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && !view.isGameLost && !view.isGameWon) {
            model.up();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && !view.isGameLost && !view.isGameWon) {
            model.down();
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            model.rollback();
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            model.randomMove();
        }
        if (model.maxTile >= WINNING_TILE) {
            view.isGameWon = true;
        }
        if (!model.canMove()) {
            view.isGameLost = true;
        }
        view.repaint();
    }

    public void resetGame() {
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
        model.score = 0;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }
}

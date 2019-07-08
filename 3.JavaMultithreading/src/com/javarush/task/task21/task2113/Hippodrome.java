package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("One", 3, 0));
        game.horses.add(new Horse("Two", 3, 0));
        game.horses.add(new Horse("Three", 3, 0));
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                
            }
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        for (Horse horse : horses) {
            if (winner == null) {
                winner = horse;
            }
            if (horse.getDistance() > winner.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}

package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int i) {
        duration = i;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder listOfDishes = new StringBuilder();
        for (int i = 1; i < Dish.values().length; i++) {
            listOfDishes.append(Dish.values()[i - 1] + ", ");
        }
        listOfDishes.append(Dish.values()[Dish.values().length - 1] + ".");
        return listOfDishes.toString();
    }
}

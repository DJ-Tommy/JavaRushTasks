package com.javarush.task.task27.task2712.kitchen;

public enum  Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringBuilder listOfDishes = new StringBuilder();
        for (int i = 1; i < Dish.values().length; i++) {
            listOfDishes.append(Dish.values()[i - 1] + ", ");
        }
        listOfDishes.append(Dish.values()[Dish.values().length - 1] + ".");
        return listOfDishes.toString();
    }
}

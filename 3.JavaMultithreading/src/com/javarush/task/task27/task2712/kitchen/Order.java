package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) {
            return "";
        }
        StringBuilder dishesList = new StringBuilder();
        for (int i = 0; i < dishes.size(); i++) {
            if (i != dishes.size() - 1) {
                dishesList.append(dishes.get(i) + ", ");
            } else {
                dishesList.append(dishes.get(i));
            }
        }
        return "Your order: [" + dishesList.toString() + "] of " + tablet.toString();
    }
}

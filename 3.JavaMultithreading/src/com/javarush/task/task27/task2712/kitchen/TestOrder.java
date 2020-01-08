package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        Dish[] allDishes = Dish.values();
        int count = (int) (10 * Math.random());
        for (int i = -1; i < count / 3; i++) {
            Dish dish = allDishes[(int) (allDishes.length * Math.random())];
            if (!dishes.contains(dish)) {
                dishes.add(dish);
            }
        }

    }
}

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
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public int getTotalCookingTime() {
        int time = 0;
        for (Dish dish : dishes) {
            time += dish.getDuration();
        }
        return time;
    }

    public boolean isEmpty() {
        return dishes.size() < 1;
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

    public List<Dish> getDishes() {
        return dishes;
    }
}

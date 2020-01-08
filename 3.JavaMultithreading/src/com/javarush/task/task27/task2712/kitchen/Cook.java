package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private String name;
    private boolean busy = false;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        try {
            Thread.sleep(10 * order.getTotalCookingTime());
        } catch (InterruptedException e) {
        }
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name,
                order.getTotalCookingTime() * 60, order.getDishes()));

        ConsoleHelper.writeMessage("Start cooking - " + order.toString() + ", cooking time " + order.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);

        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    StatisticManager statisticManager = StatisticManager.getInstance();
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Set<Cook> cooks = statisticManager.getInstance().getCooks();
                while (true) {
                    if (orderQueue.peek() != null) {
                        for (Cook cook : cooks) {
                            if (!cook.isBusy()) {
                                cook.startCookingOrder(orderQueue.poll());
                            }
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) { }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

    }


    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}

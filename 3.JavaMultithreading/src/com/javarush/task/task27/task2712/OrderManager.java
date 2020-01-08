package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue;

    public OrderManager() {
        this.orderQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void update(Observable o, Object arg) {
            orderQueue.add((Order) arg);

    }
}

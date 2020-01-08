package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        DirectorTablet directorTablet = new DirectorTablet();
        StatisticManager statisticManager = StatisticManager.getInstance();
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 50));
        }
        Cook cook = new Cook("Vasuus");
        statisticManager.register(cook);
        Cook cook2 = new Cook("Vasuus2");
        statisticManager.register(cook2);
        OrderManager orderManager = new OrderManager();
        for (Tablet tablet : tablets) {
            tablet.addObserver(orderManager);
        }
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);
        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        thread.interrupt();

        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}

package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {

    public static void main(String[] args) {
        DirectorTablet directorTablet = new DirectorTablet();
        Tablet tablet = new Tablet(99);
        Tablet tablet2 = new Tablet(22);
        Tablet tablet3 = new Tablet(333);
        Cook cook = new Cook("Vasuus");
        Cook cook2 = new Cook("Vasuus2");
        Cook cook3 = new Cook("Vasuus3");
        tablet.addObserver(cook);
        tablet2.addObserver(cook2);
        tablet3.addObserver(cook3);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);
        cook3.addObserver(waiter);
        tablet.createOrder();
        tablet2.createOrder();
        tablet3.createOrder();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}

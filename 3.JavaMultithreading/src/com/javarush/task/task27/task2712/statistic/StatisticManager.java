package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {
    private static StatisticManager statisticManager;

    private StatisticManager() {
        this.statisticManager = new StatisticManager();
    }

    public static StatisticManager getInstance() {
        if (statisticManager == null) {
            return new StatisticManager();
        } else {
            return statisticManager;
        }
    }

    public void register(EventDataRow data) {

    }

}

package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager statisticManager;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();


    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (statisticManager == null) {
            statisticManager = new StatisticManager();
        }
        return statisticManager;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Set<Cook> getCooks() {
        return cooks;
    }

    public Map<Date, Map<String, Integer>> getCookerTimes() {
        Map<Date, Map<String, Integer>> cookersTimes = new HashMap<>();
        List<EventDataRow> listEvents = statisticStorage.getStorage(EventType.COOKED_ORDER);

        for (EventDataRow eventDataRow : listEvents) {
            Date date = eventDataRow.getDate();
            long tempMilis = date.getTime() / 86400000;
            date.setTime(tempMilis * 86400000 + 1);
            Map<String, Integer> cookerTimes = new HashMap<>();
            if (cookersTimes.get(date) != null) {
                cookerTimes.putAll(cookersTimes.get(date));
            }
            String cookName = ((CookedOrderEventDataRow) eventDataRow).getCookName();
            int duration = eventDataRow.getTime();
            if (duration == 0) {
                continue;
            }
            if (cookersTimes.containsKey(date) && cookersTimes.get(date).containsKey(cookName)) {
                duration += cookersTimes.get(date).get(cookName);
            }
            cookerTimes.put(cookName, duration);
            cookersTimes.put(date, cookerTimes);
        }

        return cookersTimes;
    }

    public Map<Date, Long> getProfitPerDay() {
        Map<Date, Long> mapProfitPerDay = new HashMap<>();
        List<EventDataRow> listEvents = statisticStorage.getStorage(EventType.SELECTED_VIDEOS);
        for (EventDataRow eventDataRow : listEvents) {
            Date date = eventDataRow.getDate();
            long tempMilis = date.getTime() / 86400000;
            date.setTime(tempMilis * 86400000 + 1);
            if (((VideoSelectedEventDataRow) eventDataRow).getAmount() == 0) {
                continue;
            }
            long amount = ((VideoSelectedEventDataRow) eventDataRow).getAmount();
            if (mapProfitPerDay.containsKey(date)) {
                amount += mapProfitPerDay.get(date);
            }
            mapProfitPerDay.put(date, amount);
        }
        return mapProfitPerDay;
    }


    private class StatisticStorage {

        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            EventType[] types = EventType.values();
            for (int i = 0; i < types.length; i++) {
                storage.put(types[i], new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public List<EventDataRow> getStorage(EventType eventType) {
            return storage.get(eventType);
        }
    }
}

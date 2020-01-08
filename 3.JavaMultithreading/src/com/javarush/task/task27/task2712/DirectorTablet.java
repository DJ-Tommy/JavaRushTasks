package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    StatisticManager statisticManager = StatisticManager.getInstance();
    StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

    public void printAdvertisementProfit() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("###.00");
        Map<Date, Long> profitPerDay = statisticManager.getProfitPerDay();
        List<Date> dates = new ArrayList<>(profitPerDay.keySet());
        dates.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
        double total = 0.0;
        for (Date date : dates) {
            if (profitPerDay.get(date) > 0) {
//                String amountValueString = decimalFormat.format((profitPerDay.get(date)) / 100.0);
                String amountValueString = String.valueOf(profitPerDay.get(date) / 100.0);
                ConsoleHelper.writeMessage(dateFormat.format(date) + " - " + amountValueString);
                total += profitPerDay.get(date);
            }
        }
//        String amountTotalString = decimalFormat.format((total / 100.0));
        String amountTotalString = String.valueOf(total / 100.0);
        ConsoleHelper.writeMessage("Total - " + amountTotalString);

    }

    public void printCookWorkloading() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Map<Date, Map<String, Integer>> cookersTimes = statisticManager.getCookerTimes();
        List<Date> dates = new ArrayList<>(cookersTimes.keySet());
        dates.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
        for (Date date : dates) {
            ConsoleHelper.writeMessage(dateFormat.format(date));
            List<String> names = new ArrayList<>(cookersTimes.get(date).keySet());
            Collections.sort(names);
            for (String name : names) {
                if (cookersTimes.get(date).get(name) == 0 || cookersTimes.get(date).get(name) == null) {
                    continue;
                }
                int timeCooking = cookersTimes.get(date).get(name) / 60;
                if ((timeCooking * 60) < cookersTimes.get(date).get(name)) {
                    timeCooking++;
                }
                ConsoleHelper.writeMessage(name + " - " + timeCooking + " min");
            }
            ConsoleHelper.writeMessage("");

        }

    }

    public void printActiveVideoSet() {
        List<Advertisement> activeVideos = statisticAdvertisementManager.getActiveAdvertisements();
        activeVideos.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : activeVideos) {
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
        }

    }

    public void printArchivedVideoSet() {
        List<Advertisement> inactiveVideos = statisticAdvertisementManager.getInactiveAdvertisements();
        inactiveVideos.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : inactiveVideos) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }

    }
}

package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private int maxProfit = 0;
    private List<List<Advertisement>> resultList = new ArrayList<>();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> fullList = storage.list();
        if (fullList.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        Iterator<Advertisement> iterator = fullList.iterator();

        while (iterator.hasNext()) {
            Advertisement advertisement = iterator.next();
            if (advertisement.getDuration() > timeSeconds || advertisement.getAmountPerOneDisplaying() < 1) {
                iterator.remove();
            }
        }

        createListWithMaxProfit(fullList);

        if (resultList.isEmpty()) {
            throw new NoVideoAvailableException();
        }

        resultList.sort(new Comparator<List<Advertisement>>() {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                if (time(o1) > time(o2)) {
                    return -1;
                } else if (time(o1) < time(o2)) {
                    return 1;
                } else {
                    return o1.size() - o2.size();
                }
            }
        });

        List<Advertisement> result = resultList.get(0);
        result.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()) {
                    if (o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration() > o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration()) {
                        return -1;
                    } else if (o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration() < o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration()) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else if (o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (Advertisement advertisement : result) {
            advertisement.revalidate();
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " +
                    advertisement.getAmountPerOneDisplaying() + ", " +
                    (advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
        }

    }

    private void createListWithMaxProfit(List<Advertisement> list) {
        int profitOfList = profit(list);
        int timeOfList = time(list);
        if (timeOfList > timeSeconds) {
            for (int i = 0; i < list.size(); i++) {
                List<Advertisement> newList = new ArrayList<>(list);
                newList.remove(i);
                createListWithMaxProfit(newList);
            }
        } else {
            if (profitOfList > maxProfit) {
                maxProfit = profitOfList;
                resultList.clear();
                resultList.add(list);
            } else if (profitOfList == maxProfit && !resultList.contains(list)) {
                resultList.add(list);
            }
        }
    }

    private int time(List<Advertisement> list) {
        int time = 0;
        for (Advertisement advertisement : list) {
            time += advertisement.getDuration();
        }
        return time;
    }

    private int profit(List<Advertisement> list) {
        int sum = 0;
        for (Advertisement advertisement : list) {
            sum += advertisement.getAmountPerOneDisplaying();
        }
        return sum;
    }


}

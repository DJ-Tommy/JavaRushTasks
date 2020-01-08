package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager statisticAdvertisementManager;
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (statisticAdvertisementManager == null) {
            statisticAdvertisementManager = new StatisticAdvertisementManager();
        }
        return statisticAdvertisementManager;
    }

    public List<Advertisement> getActiveAdvertisements() {
        List<Advertisement> resultList = new ArrayList<>();
        List<Advertisement> allVideos = advertisementStorage.list();
        for (Advertisement advertisement : allVideos) {
            if (advertisement.getHits() > 0) {
                resultList.add(advertisement);
            }
        }
        return resultList;
    }

    public List<Advertisement> getInactiveAdvertisements() {
        List<Advertisement> resultList = new ArrayList<>();
        List<Advertisement> allVideos = advertisementStorage.list();
        for (Advertisement advertisement : allVideos) {
            if (advertisement.getHits() == 0) {
                resultList.add(advertisement);
            }
        }
        return resultList;
    }




}

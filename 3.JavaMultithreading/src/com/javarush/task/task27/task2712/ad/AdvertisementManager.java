package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AdvertisementManager extends Observable {
    private int timeSeconds;

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> list = storage.list();
        List<Advertisement> ads = findMaximumMoneyVideos(list, timeSeconds);
        if (ads == null || ads.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        int totalDuration = 0;
        long amount = 0L;
        for (Advertisement advertisement : ads) {
            totalDuration += advertisement.getDuration();
            amount += advertisement.getAmountPerOneDisplaying();
        }

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(ads, amount, totalDuration));

        for (Advertisement advertisement : ads) {
            advertisement.revalidate();
            String pattern = "##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            double oneSecondPrice = ((double) advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()) * 1000;
            String format = decimalFormat.format(Math.floor(oneSecondPrice));
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", " + format);
        }

    }

    public List<Advertisement> findMaximumMoneyVideos(List<Advertisement> initialList, int secondsRemainder) {
        List<Advertisement> result = new ArrayList<>();
        //если секунд для показа не осталось, или не осталось роликов для показа,
        // то все - выходим = возвращаем пустой список
        if (secondsRemainder <= 0 || initialList.isEmpty()) {
            return result;
        }
        //итерируем лист


        //находим максимальный нужный ролик
        List<Advertisement> candidates = new ArrayList<>();
        Collections.sort(initialList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o2.getAmountPerOneDisplaying() <= o1.getAmountPerOneDisplaying()) {
                    if (o2.getAmountPerOneDisplaying() == o1.getAmountPerOneDisplaying()) {
                        return 0;
                    }
                    return -1;
                }
                return 1;
            }
        });

        //копируем лист, чтобы не портить предыдущий
        List<Advertisement> copyOfInitialList = new ArrayList<>(initialList);

        //выбираем кандидатов с макс ценой
        long maxPrice = copyOfInitialList.get(0).getAmountPerOneDisplaying(); // берем ценник для первого - он уже максимальнгый после сорта и с ним сравниваем остальные.
        candidates = copyOfInitialList.stream().filter(advertisement ->
                advertisement.getAmountPerOneDisplaying() == maxPrice).collect(Collectors.toList());

        //из выбранных с макс ценой выбираем кандидатов с макс временем
        Collections.sort(candidates, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                if (o2.getDuration() <= o1.getDuration()) {
                    if (o2.getDuration() == o1.getDuration()) {
                        return 0;
                    }
                    return -1;
                }
                return 1;
            }
        });

        Advertisement candidate = candidates.get(0);
        //добавляем ролик в результирующий лист, если его длина не превышает остаток!

        if ((candidate.getDuration() <= secondsRemainder) && (candidate.getHits() > 0)) {
            result.add(candidate);
            secondsRemainder = secondsRemainder - candidate.getDuration();
        }
        copyOfInitialList.remove(candidate);
        //запускаем следующий рекурсивный шаг, вычитаем время показа выбранного ролика - кандидата
        result.addAll(findMaximumMoneyVideos(copyOfInitialList, secondsRemainder));
        return result;
    }
}

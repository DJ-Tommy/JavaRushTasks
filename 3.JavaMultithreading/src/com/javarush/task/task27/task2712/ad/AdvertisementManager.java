package com.javarush.task.task27.task2712.ad;

/*
* Ресторан(9)
Нам понадобится исключение, которое поможет обработать ситуацию, если у нас не будет получаться подобрать рекламные ролики.

1. Создадим unchecked исключение NoVideoAvailableException в пакете ad.

2. Разберем подробно метод void processVideos() в AdvertisementManager.
2.1. Удаляем из него вывод в консоль "calling processVideos method"
Метод должен:
2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду. (Пока делать не нужно, сделаем позже).
2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException,
которое перехватить в оптимальном месте (подумать, где это место) и с уровнем Level.INFO логировать фразу
"No video is available for the order " + order
2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа одного рекламного
ролика в копейках. Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки.
Используйте метод Collections.sort
(Тоже пока делать не нужно, сделаем позже).

Пример для заказа [Water]:
First Video is displaying... 50, 277
где First Video - название рекламного ролика
где 50 - стоимость показа одного рекламного ролика в копейках
где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используйте методы из класса Advertisement.
2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
2.5.1. Бросать UnsupportedOperationException, если количество показов не положительное число.
2.5.2. Уменьшать количество показов.


Требования:
1. В методе processVideos() не должно быть вывода в консоль.
2. В случае, если список видео для воспроизведения пуст, должно быть брошено исключение NoVideoAvailableException из метода processVideos().
3. Исключение NoVideoAvailableException должно быть перехвачено и в лог должна быть записана строка об отсутствии видео для данного заказа (пример в условии).
4. Класс NoVideoAvailableException в пакете ad должен быть потомком класса RuntimeException.
5. Метод revalidate() должен быть реализован в соответствии с условием задачи.

* */

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

    /*
    * Ресторан(10)
Рекурсию используют тогда, когда алгоритм решения задачи совпадает с алгоритмом решения подзадачи (части).
У нас как раз такой случай. Нам нужно сделать полный перебор всех вариантов и выбрать из них лучший.

Напомню, рекурсия пишется по следующему принципу:
а) условие выхода/окончания рекурсии
б) условие продолжения - вызов самой себя с набором параметров предыдущего шага.
В любое время ты можешь почитать в инете подробную информацию по написанию рекурсии.

Текущее задание - реализовать п.2.2 предыдущего задания с помощью рекурсии.
(подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду)
Рекурсивный метод должен выбрать набор рекламных роликов, которые будут показаны посетителю.

Этот набор должен удовлетворять следующим требованиям:
1. сумма денег, полученная от показов, должна быть максимальной из всех возможных вариантов
2. общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа;
3. для одного заказа любой видео-ролик показывается не более одного раза;
4. если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов, то:
4.1. выбрать тот вариант, у которого суммарное время максимальное;
4.2. если суммарное время у этих вариантов одинаковое, то выбрать вариант с минимальным количеством роликов;
5. количество показов у любого рекламного ролика из набора - положительное число.

Также не забудь реализовать п.2.4 из предыдущего задания (вывести на экран все подходящие ролики).

Для каждого показанного видео-ролика должен быть вызван метод revalidate().


Требования:
1. Сумма денег, полученная от показов, должна быть максимальной из всех возможных вариантов.
2. Общее время показа рекламных роликов НЕ должно превышать время приготовления блюд для текущего заказа.
3. Для одного заказа любой видео-ролик должен показываться не более одного раза.
4. Если существует несколько вариантов набора видео-роликов с одинаковой суммой денег, полученной от показов,
    то должен быть выбран вариант с максимальным суммарным временем.
5. Если существует несколько вариантов набора видео-роликов с одинаковой суммой денег и одинаковым суммарным временем,
    то должен быть выбран вариант с минимальным количеством роликов.
6. В набор должны отбираться только ролики с положительным числом показов.
7. Для каждого показанного ролика должен быть вызван метод revalidate.
    *
    * */



    /*
    *
    * 2. Разберем подробно метод void processVideos() в AdvertisementManager.
2.1. Удаляем из него вывод в консоль "calling processVideos method"
Метод должен:
2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду. (Пока делать не нужно, сделаем позже).
2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException, которое перехватить в оптимальном месте (подумать, где это место) и с уровнем Level.INFO логировать фразу "No video is available for the order " + order
2.4. Отобразить все рекламные ролики, отобранные для показа, в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
Вторичная сортировка - по увеличению стоимости показа одной секунды рекламного ролика в тысячных частях копейки.
Используйте метод Collections.sort
(Тоже пока делать не нужно, сделаем позже).

Пример для заказа [Water]:
First Video is displaying... 50, 277
где First Video - название рекламного ролика
где 50 - стоимость показа одного рекламного ролика в копейках
где 277 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используйте методы из класса Advertisement.
    * */


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

        //        totalDuration = ads.stream().mapToInt(Advertisement::getDuration).sum();
        //        amount = ads.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
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
        //убираем кандидата из КОПИИ тестируемого листа
        copyOfInitialList.remove(candidate);
        //запускаем следующий рекурсивный шаг, вычитаем время показа выбранного ролика - кандидата
        result.addAll(findMaximumMoneyVideos(copyOfInitialList, secondsRemainder));
        return result;
    }
}








/*
package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private long maxProfit = 0;
    private List<List<Advertisement>> resultList = new ArrayList<>();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> fullList = storage.list();
        if (fullList.isEmpty()) {
            resultList = null;
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
            resultList = null;
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

        VideoSelectedEventDataRow videoSelectedEventDataRow = new VideoSelectedEventDataRow(result, profit(result), time(result));
        StatisticManager.getInstance().register(videoSelectedEventDataRow);

        for (Advertisement advertisement : result) {
            advertisement.revalidate();
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... " +
                    advertisement.getAmountPerOneDisplaying() + ", " +
                    (advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
        }

    }

    private void createListWithMaxProfit(List<Advertisement> list) {
        long profitOfList = profit(list);
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

    private long profit(List<Advertisement> list) {
        int sum = 0;
        if (list == null) {
            return 0;
        }
        for (Advertisement advertisement : list) {
            sum += advertisement.getAmountPerOneDisplaying();
        }
        return sum;
    }


}
*/

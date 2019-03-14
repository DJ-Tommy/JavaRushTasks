package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stallone1", df.parse("JUNE 2 1912"));
        map.put("Stallone2", df.parse("MARCH 3 1975"));
        map.put("Stallone3", df.parse("APRIL 4 1960"));
        map.put("Stallone4", df.parse("MAY 1 1965"));
        map.put("Stallone5", df.parse("AUGUST 1 1982"));
        map.put("Stallone6", df.parse("OCTOBER 1 1989"));
        map.put("Stallone7", df.parse("DECEMBER 1 1960"));
        map.put("Stallone8", df.parse("JULY 1 1950"));
        map.put("Stallone9", df.parse("SEPTEMBER 1 1986"));

        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Date date = iterator.next().getValue();
            if (date.getMonth() > 4 && date.getMonth() < 8) {
                iterator.remove();
            }
        }

        //напишите тут ваш код

    }

    public static void main(String[] args) throws ParseException{

        HashMap<String, Date> map = createMap();



    }
}

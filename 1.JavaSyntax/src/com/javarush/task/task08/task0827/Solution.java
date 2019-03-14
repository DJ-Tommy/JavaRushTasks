package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {

        DateFormat df = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date stop = new Date();
        try {
            stop = df.parse(date);
        } catch (Exception e) {
        }
        Date start = new Date(0);
        start.setHours(0);
        start.setYear(stop.getYear());
        if ((int)((stop.getTime() - start.getTime()) / (1000 * 60 * 60 * 24)) % 2 == 0) {
            return true;
        }

        return false;
    }
}

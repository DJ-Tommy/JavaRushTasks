package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<String> llist = new ArrayList<>();

        for (String s : array) {
            if (isNumber(s)) {
                num.add(Integer.parseInt(s));
            } else {
                strings.add(s);
            }
        }
        String[] str = strings.toArray(new String[0]);
        Integer[] n = num.toArray(new Integer[0]);

        for (int j = 1; j < str.length; j++) {
            for (int i = 1; i < str.length; i++) {
                if (!isGreaterThan(str[i], str[i - 1])) {
                    String min = new String(str[i]);
                    str[i] = new String(str[i - 1]);
                    str[i - 1] = new String(min);
                }
            }
        }

        for (int j = 1; j < n.length; j++) {
            for (int i = 1; i < n.length; i++) {
                if (n[i] > n[i - 1]) {
                    int max = n[i];
                    n[i] = n[i - 1];
                    n[i - 1] = max;
                }
            }
        }

        int ss = 0;
        int nn = 0;

        for (String s : array) {
            if (!isNumber(s)) {
                llist.add(str[ss]);
                ss++;
            } else {
                llist.add(String.valueOf(n[nn]));
                nn++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = llist.get(i);
        }


    }


    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}

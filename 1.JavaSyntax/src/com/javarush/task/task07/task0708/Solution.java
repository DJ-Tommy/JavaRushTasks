package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();
        int maxSize = 0;

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
            if (strings.get(i).length() > maxSize) {
                maxSize = strings.get(i).length();
            }
        }

        for (String s : strings) {
            if (s.length() == maxSize) {
                System.out.println(s);
            }
        }


        //напишите тут ваш код
    }
}

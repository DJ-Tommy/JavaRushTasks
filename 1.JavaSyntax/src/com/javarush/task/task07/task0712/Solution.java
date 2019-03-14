package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();
        int minSize = 0;
        int maxSize = 0;

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
            if (i == 0) minSize = strings.get(0).length();
            if (strings.get(i).length() > maxSize) maxSize = strings.get(i).length();
            if (strings.get(i).length() < minSize) minSize = strings.get(i).length();
        }

        for (String s : strings) {
            if (s.length() == minSize || s.length() == maxSize) {
                System.out.println(s);
                break;
            }
        }

        //напишите тут ваш код
    }
}

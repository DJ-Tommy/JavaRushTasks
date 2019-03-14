package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = 0;
        int minimum = 0;
        int[] mas = new int[20];
        for (int i = 0; i < 20; i++) {
            mas[i] = Integer.parseInt(reader.readLine());
            if (i == 0) {
                minimum = mas[0];
                maximum = mas[0];
            }
            if (minimum > mas[i]) minimum = mas[i];
            if (maximum < mas[i]) maximum = mas[i];

        }

        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}

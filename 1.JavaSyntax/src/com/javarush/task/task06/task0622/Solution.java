package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mas = new int[5];
        for (int i = 0; i < 5; i++) {
            mas[i] = Integer.parseInt(reader.readLine());
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (mas[i] > mas[i + 1]) {
                    int a = mas[i + 1];
                    mas[i + 1] = mas[i];
                    mas[i] = a;
                }
            }
        }

        for (int a : mas) {
            System.out.println(a);
        }
    }
}

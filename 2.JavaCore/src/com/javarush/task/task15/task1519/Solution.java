package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String value = reader.readLine();
            if (value.equals("exit")) {
                return;
            }

            try {
                Double d = Double.parseDouble(value);
                if (value.contains(".")) {
                    print(d);
                    continue;
                } else {
                    Integer i = Integer.parseInt(value);
                    if (i > 0 && i < 128) {
                        Short s = Short.parseShort(value);
                        print(s);
                        continue;
                    } else {
                        print(i);
                        continue;
                    }
                }

            } catch (Exception e) {
                print(value);
                continue;
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

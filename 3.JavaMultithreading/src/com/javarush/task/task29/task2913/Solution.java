package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder result = new StringBuilder();
        int i = a;
        while (true){
            if (a > b && i > b) {
                result.append(i + " ");
                i--;

            }
            if (a < b && i < b) {
                result.append(i + " ");
                i++;
            }
            if (a == b || i == b) {
                break;
            }
        }
        result.append(b);
        return result.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}
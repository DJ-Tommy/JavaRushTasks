package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        while (true) {
            if (num / 10 > 0) {
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
                num /= 10;

            } else {
                break;
            }
        }
        if (num % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        System.out.println("Even: " + even  + " Odd: " + odd);
    }
}

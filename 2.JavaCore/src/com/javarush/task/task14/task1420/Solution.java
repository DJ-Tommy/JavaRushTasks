package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        if (first < 1 || second < 1) {
            throw new Exception() ;
        }

        int min = first;
        if (first > second) {
            min = second;
        }

        //System.out.println(first);
        //System.out.println(second);

        int num = 0;

        for (int i = 1; i <= min; i++) {
            if (first % i == 0 && second % i == 0) {
                num = i;
            }
        }
        System.out.println(num);


    }
}

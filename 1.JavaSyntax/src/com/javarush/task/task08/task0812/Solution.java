package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int val1 = 1;
        int val2 = 1;

        for (int i = 0; i < 10; i++) {
            list.add(Integer.valueOf(reader.readLine()));
        }

        for (int i = 1; i < 10; i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                val1++;
            } else {
                if (val1 > val2) {
                    val2 = val1;
                }
                val1 = 1;
            }
        }

        System.out.println(val1 > val2 ? val1 : val2);

    }
}
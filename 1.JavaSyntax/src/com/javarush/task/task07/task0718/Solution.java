package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int len = 0;
        int result = -1;
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
            if (list.get(i).length() >= len) {
                len = list.get(i).length();
            } else {
                result = i;
            }
        }

        if (result >= 0) System.out.println(result);

        //напишите тут ваш код
    }
}


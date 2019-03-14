package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(name);
        byte[] b = new byte[file.available()];
        file.read(b, 0, b.length);
        file.close();
        byte min = b[0];

        for (int i = 1; i < b.length; i++) {
            if (b[i] < min) {
                min = b[i];
            }
        }
        System.out.println(min);
    }
}

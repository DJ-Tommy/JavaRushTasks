package com.javarush.task.task18.task1821;

/*
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String name = args[0];
//        String name = "d:\\1.txt";
        int[] res = new int[128];
        for (int i = 0; i < 128; i++) {
            res[i] = 0;
        }

        FileInputStream inputStream = new FileInputStream(name);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();

        for (byte bb : b) {
            res[bb]++;
        }

        for (int i = 0; i < 128; i++) {
            if (res[i] > 0) {
                System.out.println((char)i + " " + res[i]);
            }
        }

    }
}

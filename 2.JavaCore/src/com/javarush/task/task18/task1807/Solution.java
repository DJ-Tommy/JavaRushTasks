package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(name);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();

        int count = 0;
        byte bbb = (byte)(',');
        for (byte bb : b) {
            if (bb == bbb) {
                count++;
            }
        }

        System.out.println(count);


    }
}

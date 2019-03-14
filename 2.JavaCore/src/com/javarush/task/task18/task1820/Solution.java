package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String name1 = "d:\\2.txt";
//        String name2 = "d:\\3.txt";
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(name1);
        FileOutputStream outputStream = new FileOutputStream(name2, true);

        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        String line = new String(b);
        String[] strings = line.split(" ");
        int[] num = new int[strings.length];

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) Math.round(Double.parseDouble(strings[i]));
            outputStream.write(String.valueOf(num[i]).getBytes());
            outputStream.write(' ');
        }

        inputStream.close();
        outputStream.close();

    }
}

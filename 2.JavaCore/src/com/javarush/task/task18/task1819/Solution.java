package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(name1);
        byte[] b1 = new byte[inputStream1.available()];
        inputStream1.read(b1);
        inputStream1.close();
        FileOutputStream outputStream = new FileOutputStream(name1);
        FileInputStream inputStream2 = new FileInputStream(name2);
        byte[] b2 = new byte[inputStream2.available()];
        inputStream2.read(b2);
        inputStream2.close();
        byte[] b = new byte[b1.length + b2.length];
        for (int i = 0; i < b2.length + b1.length; i++) {
            if (i < b2.length) {
                b[i] = b2[i];
            } else {
                b[i] = b1[i - b2.length];
            }
        }
        outputStream.write(b);
        outputStream.close();

    }
}

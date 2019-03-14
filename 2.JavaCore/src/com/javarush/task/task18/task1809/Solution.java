package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(name1);
        FileOutputStream outputStream = new FileOutputStream(name2);
        byte[] b = new byte[inputStream.available()];
        byte[] a = new byte[inputStream.available()];
        inputStream.read(b);
        for (int i = 0; i < b.length; i++) {
            a[i] = b[b.length - i - 1];
        }
        outputStream.write(a);
        inputStream.close();
        outputStream.close();

    }
}

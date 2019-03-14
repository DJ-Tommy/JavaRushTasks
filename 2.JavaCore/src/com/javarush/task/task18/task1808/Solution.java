package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(name1);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        FileOutputStream outputStream1 = new FileOutputStream(name2);
        FileOutputStream outputStream2 = new FileOutputStream(name3);
        int size1 = b.length / 2 + b.length % 2;
        outputStream1.write(b, 0, size1);
        outputStream2.write(b, size1, b.length - size1);
        outputStream1.close();
        outputStream2.close();
    }
}

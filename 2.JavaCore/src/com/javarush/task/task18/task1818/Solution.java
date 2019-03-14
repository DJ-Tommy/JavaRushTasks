package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        reader.close();

        FileOutputStream outputStream1 = new FileOutputStream(name1, false);
        FileInputStream inputStream2 = new FileInputStream(name2);
        FileInputStream inputStream3 = new FileInputStream(name3);

        byte[] b2 = new byte[inputStream2.available()];
        inputStream2.read(b2);
        inputStream2.close();

        byte[] b3 = new byte[inputStream3.available()];
        inputStream3.read(b3);
        inputStream3.close();

        outputStream1.write(b2);
        outputStream1.close();

        FileOutputStream outputStream2 = new FileOutputStream(name1, true);
        outputStream2.write(b3);
        outputStream2.close();

    }
}

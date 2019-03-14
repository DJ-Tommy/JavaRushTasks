package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        InputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            System.out.print((char) data);
        }

        fileInputStream.close();





    }
}
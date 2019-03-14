package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String key = args[0];
        String fileOutputName = args[2];

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);

        if (key.equals("-e")) {
            for (int i = 0; i < b.length; i++) {
                if (b[i] < 127) {
                    b[i] += 1;
                } else {
                    b[i] = 0;
                }
            }
        }

        if (key.equals("-d")) {
            for (int i = 0; i < b.length; i++) {
                if (b[i] > 0) {
                    b[i] -= 1;
                } else {
                    b[i] = 127;
                }
            }
        }

        outputStream.write(b);
        inputStream.close();
        outputStream.close();



    }

}

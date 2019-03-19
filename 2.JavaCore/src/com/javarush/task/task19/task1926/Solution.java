package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (true) {
            String line = reader.readLine();
            StringBuilder str = new StringBuilder();
            if (line == null) {
                break;
            }
            for (int i = 0; i < line.length(); i++) {
                str.append(line.substring(line.length() - 1 - i, line.length() - i));
            }
            System.out.println(str);
        }
        reader.close();
        fileReader.close();
    }
}

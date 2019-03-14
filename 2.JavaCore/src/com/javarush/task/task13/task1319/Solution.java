package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedWriter file = new BufferedWriter(new FileWriter(fileName));

        while (true) {
            String string = reader.readLine();
            file.write(string + "\n");

            if (string.equals("exit")) {
                break;
            }

        }

        reader.close();
        file.close();
    }
}

package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);
        long count = 0;
        while (true) {
            count++;
            if (!fileReader.ready()) {
                break;
            }
            int b = fileReader.read();
            if (count % 2 == 0) {
                fileWriter.write(b);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}

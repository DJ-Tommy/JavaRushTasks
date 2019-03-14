package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(name1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(name2));

        StringBuilder result = new StringBuilder();

        while (true) {
            String line = fileReader.readLine();
            if (line == null) {
                break;
            }
            result.append(line.replaceAll("\\p{Punct}", ""));
        }

        fileWriter.write(result.toString());
        fileReader.close();
        fileWriter.close();
    }
}

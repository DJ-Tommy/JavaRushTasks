package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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

        StringBuilder builder = new StringBuilder();

        while (true) {
            String line = fileReader.readLine();
            if (line == null) {
                break;
            }
            builder.append(line);
        }
        String[] value = builder.toString().split(" ");
        StringBuilder result = new StringBuilder();

        for (String s : value) {
            try {
                Integer i = Integer.parseInt(s);
                result.append(i + " ");
            } catch (Exception e) {
                continue;
            }
        }

        fileWriter.write(result.toString());
        fileReader.close();
        fileWriter.close();

    }
}

package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
//        String name = "d:\\1.txt";
        reader.close();

        FileReader fileReader = new FileReader(name);
        BufferedReader file = new BufferedReader(fileReader);

        StringBuilder builder = new StringBuilder();
        while (true) {
            String line = file.readLine();
            if (line == null) {
                break;
            }
            builder.append(" " + line + " ");
        }
        fileReader.close();
        file.close();

        String[] strings = builder.toString().split("\\bworld\\b");
//        System.out.println(builder);
        System.out.println(strings.length - 1);

    }
}

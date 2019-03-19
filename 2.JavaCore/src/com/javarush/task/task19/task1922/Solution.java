package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
        words.add("12");
        words.add("34");
        words.add("23");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        while (true) {
            String line = reader.readLine();

            if (line == null) {
                break;
            }
            line = " " + line + " ";
            long result = 0;

            for (String s : words) {
                result += line.split("\\b" + s + "\\b").length - 1;
            }
            if (result == 2) {
                System.out.println(line);
            }
        }
        fileReader.close();
        reader.close();
    }
}

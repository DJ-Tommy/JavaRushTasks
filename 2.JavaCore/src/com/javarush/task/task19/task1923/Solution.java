package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName1);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileName2);

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            stringBuilder.append(" " + line + " ");
        }
        reader.close();
        fileReader.close();

        String[] str = stringBuilder.toString().split(" ");
        for (String s : str) {
            if (s.matches(".*\\d.*") && s.matches(".*\\w.*")) {
                list.add(s);
            }
        }
        for (String s : list) {
            fileWriter.write(s + " ");
        }
        fileWriter.close();
    }
}

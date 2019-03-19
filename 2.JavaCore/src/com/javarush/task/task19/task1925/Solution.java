package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String name1 = args[0];
        String name2 = args[1];
        FileReader fileReader = new FileReader(name1);
        BufferedReader reader = new BufferedReader(fileReader);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] str = line.split(" ");
            for (String s : str) {
                if (s.length() > 6) {
                    list.add(s);
                }
            }
        }
        reader.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(name2);

        for (int i = 0; i < list.size(); i++) {
            fileWriter.write(list.get(i));
            if (i < list.size() - 1) {
                fileWriter.write(",");
            }
        }
        fileWriter.close();
    }
}

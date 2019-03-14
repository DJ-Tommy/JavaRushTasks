package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        TreeSet<String> parts = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String[] parseDot = name1.split("\\.");
        parts.add(parseDot[parseDot.length - 1]);
        fileName = name1.substring(0, name1.length() - parseDot[parseDot.length - 1].length() - 1);

        while (true) {
            String name = reader.readLine();
            if (name.equals("end")) {
                break;
            }
            String[] parse = name.split("\\.");
            parts.add(parse[parse.length - 1]);
        }

        FileOutputStream outputStream = new FileOutputStream(fileName, true);

        for (String s : parts) {
            FileInputStream inputStream = new FileInputStream(fileName + "." + s);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            inputStream.close();
            outputStream.write(b);
        }
        outputStream.close();
    }
}

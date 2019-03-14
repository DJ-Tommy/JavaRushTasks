package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int id = Integer.parseInt(args[0]);
        reader.close();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            list.add(line);
        }
        bufferedReader.close();

        for (String s : list) {
            String[] item = s.split(" ");
            if (Integer.parseInt(item[0]) == id) {
                System.out.println(s);
            }
        }
    }
}

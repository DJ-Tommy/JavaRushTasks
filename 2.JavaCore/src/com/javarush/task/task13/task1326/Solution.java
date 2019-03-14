package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader file = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<Integer> allData = new ArrayList<>();

        String line = file.readLine();

        while (line != null) {
            allData.add(Integer.parseInt(line));
            line = file.readLine();
        }

        inputStream.close();
        reader.close();
        file.close();

        Collections.sort(allData);

        for (int i : allData) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }



    }
}

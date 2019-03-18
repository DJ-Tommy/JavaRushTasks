package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        BufferedReader fileReader = new BufferedReader(reader);
        TreeMap<String, Double> map = new TreeMap<>();
        double max = 0;

        while (true) {
            String line = fileReader.readLine();
            if (line == null) {
                break;
            }
            String[] str = line.split(" ");
            if (!map.containsKey(str[0])) {
                map.put(str[0], Double.parseDouble(str[1]));
                if (max < map.get(str[0])) {
                    max = map.get(str[0]);
                }
            } else {
                map.put(str[0], map.get(str[0]) + Double.parseDouble(str[1]));
                if (max < map.get(str[0])) {
                    max = map.get(str[0]);
                }
            }
        }
        reader.close();
        fileReader.close();

        for (Map.Entry<String, Double> m : map.entrySet()) {
            if (m.getValue() == max) {
                System.out.println(m.getKey());
            }
        }

    }
}

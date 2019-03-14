package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(name);
        byte[] b = new byte[file.available()];
        file.read(b, 0, b.length);
        file.close();

        HashMap<Byte, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < b.length; i++) {
            int count = 0;
            for (int j = 1; j < b.length; j++) {
                if (i == j) {
                    continue;
                }
                if (b[i] == b[j]) {
                    count++;
                }
            }
            if (!map.containsKey(b[i])) {
                if (max < count) {
                    max = count;
                }
                map.put(b[i], count);
            }
        }

        for (Map.Entry<Byte, Integer> m : map.entrySet()) {
            if (m.getValue() == max) {
                System.out.print(m.getKey() + " ");
            }
        }



    }
}

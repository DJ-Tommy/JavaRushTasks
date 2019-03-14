package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String name = reader.readLine();
            if (name.equals("exit")) {
                break;
            }
            Thread t = new ReadThread(name);
            t.start();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            FileInputStream inputStream;
            byte[] b;
            int[] res = new int[256];
            for (int i = 0; i < 256; i++) {
                res[i] = 0;
            }
            try {
                inputStream = new FileInputStream(fileName);
                b = new byte[inputStream.available()];
                inputStream.read(b);
                inputStream.close();

                for (byte bb : b) {
                    res[bb]++;
                }
                int maxValue = 0;
                int maxNumber =0;

                for (int i = 1; i < 256; i++) {
                    if (res[i] > maxValue) {
                        maxValue = res[i];
                        maxNumber = i;
                    }
                }
                resultMap.put(fileName, maxNumber);



            } catch (Exception e) { }
        }
    }
}

package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder fileString = new StringBuilder();
        fileString.append(fileReader.readLine());
        fileReader.close();

        StringBuilder result = getLine(fileString.toString().split("\\s+"));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        String[] words1 = Arrays.copyOf(words, words.length);
        StringBuilder stringBuilder = new StringBuilder();

        if (words1.length == 0) {
            return stringBuilder;
        }

        int count = 0;
        boolean isFind = false;

        while (true) {
            for (int i = 1; i < words1.length; i++) {
                if (!words1[i - 1].toLowerCase().substring(words1[i - 1].length() - 1)
                        .equals(words1[i].toLowerCase().substring(0, 1))) {
                    break;
                }
                if (i == words1.length - 1) {
                    isFind = true;
                }
            }
            if (isFind) {
                break;
            }
            count++;
            int r1 = (int) (Math.random() * (words1.length));
            int r2;
            while (true) {
                r2 = (int) (Math.random() * (words1.length));
                if (r2 != r1) {
                    break;
                }
            }
            String temp = words1[r1];
            words1[r1] = words1[r2];
            words1[r2] = temp;

            if (count > 777) {
                return null;
            }
        }

        for (int i = 0; i < words1.length; i++) {
            stringBuilder.append(words1[i]);
            if (i < words1.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder;
    }
}

package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        while (true) {
            String s = reader.readLine();
            if (s.equals("end")) {
                break;
            } else {
                strings.add(s);
            }
        }

        for (String s : strings) {
            System.out.println(s);
        }
        //напишите тут ваш код
    }
}
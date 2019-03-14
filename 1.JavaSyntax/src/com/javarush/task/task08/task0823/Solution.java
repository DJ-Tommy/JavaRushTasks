package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> string = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                string.add(s.substring(i, i+1).toUpperCase());
            }
            if (i > 0) {
                if (string.get(i - 1).equals(" ")) {
                    string.add(s.substring(i, i+1).toUpperCase());
                } else {
                    string.add(s.substring(i, i+1));
                }
            }


        }
        s = "";
        for (String ss : string) {
        s += ss;
        }
        System.out.println(s);

        //напишите тут ваш код
    }
}

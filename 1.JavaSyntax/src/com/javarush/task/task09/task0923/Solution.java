package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> vowel = new ArrayList<>();
        ArrayList<Character> consonat = new ArrayList<>();
        String string = reader.readLine();
        char[] ch = string.toCharArray();
        for (char c : ch) {
            char d = ' ';
            if (d == c) {
                continue;
            }
            if (isVowel(c)) {
                vowel.add(c);
            } else {
                consonat.add(c);
            }
        }
        for (char c : vowel) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (char c : consonat) {
            System.out.print(c + " ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
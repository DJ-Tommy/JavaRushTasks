package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        int[] m = new int[4];
        try {
            for (int i = 0; i < m.length; i++) {
                if (i == 0) {
                    m[i] = string.indexOf(" ");
                } else {
                    m[i] = string.indexOf(" ", m[i - 1] + 1);
                }
            }
            if (string.indexOf(" ", m[3] + 1) > m[3]) {
                m[3] = string.indexOf(" ", m[3] + 1);
            } else if (m[3] > m[2]) {
                m[3] = string.length();
            }

            String s = string.substring(m[0] + 1, m[3]);
            return s;

        } catch (Exception e) {
            throw new TooShortStringException(e);
        }
    }

    public static class TooShortStringException extends RuntimeException{
        public TooShortStringException(Throwable cause) {
            super(cause);
        }
    }
}

package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();

    }

    public static int readInt() throws Exception {
        return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

    }

    public static double readDouble() throws Exception {
        return Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());

    }

    public static boolean readBoolean() throws Exception {
        String text = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (text.equals("true")) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

    }
}

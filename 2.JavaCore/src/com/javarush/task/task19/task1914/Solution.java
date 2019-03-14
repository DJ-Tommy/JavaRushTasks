package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(original);
        int res;

        String[] list = result.split(" ");
        if (list.length > 2 && list[1].equals("-")) {
            res = Integer.parseInt(list[0]) - Integer.parseInt(list[2]);
        } else if (list.length > 2 && list[1].equals("+")){
            res = Integer.parseInt(list[0]) + Integer.parseInt(list[2]);
        }else {
            res = Integer.parseInt(list[0]) * Integer.parseInt(list[2]);
        }

        System.out.println(list[0] + " " + list [1] + " " + list[2] + " = " + res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


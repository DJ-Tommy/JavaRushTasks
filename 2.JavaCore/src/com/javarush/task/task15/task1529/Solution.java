package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            if (name.equals("helicopter")) {
                result = new Helicopter();
            }

            if (name.equals("plane")) {
                int value = Integer.parseInt(reader.readLine());
                result = new Plane(value);
            }
        } catch (Exception e) {

        }
    }
}

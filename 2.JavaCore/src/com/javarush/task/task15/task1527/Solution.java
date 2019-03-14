package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        ArrayList<String> param = new ArrayList<>();
        String string = "";
        boolean q = false;

        for (int i = 0; i < url.length(); i++) {
            String s = url.substring(i, i + 1);
            if (s.equals("?")) {
                q = true;
                continue;
            }

            if (!q) {
                continue;
            }

            if (!s.equals("&")) {
                string += s;
            } else {
                param.add(string);
                string = "";
            }

            if (i == url.length() - 1 && !string.equals("")) {
                param.add(string);
            }

        }

        ArrayList<String> newParam = new ArrayList<>();

        for (String ss : param) {
            if (!ss.contains("=")) {
                newParam.add(ss);
                continue;
            }

            for (int i = 0; i < ss.length(); i++) {
                String s = ss.substring(i, i + 1);
                if (s.equals("=")) {
                    newParam.add(ss.substring(0, i));
                    break;
                }
            }
        }

        String paramString = "";
        for (int i = 0; i < newParam.size(); i++) {
            paramString += newParam.get(i);
            if (i < newParam.size() - 1) {
                paramString += " ";
            }
        }
        System.out.println(paramString);

        for (String ss : param) {
            if (ss.length() > 4 && ss.substring(0, 4).equals("obj=")) {
                String obj = ss.substring(4);
                try {
                    Double d = Double.parseDouble(obj);
                    alert(d);
                } catch (Exception e) {
                    alert(obj);
                }
            }
        }




    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

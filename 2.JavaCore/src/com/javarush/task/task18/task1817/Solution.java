package com.javarush.task.task18.task1817;

/* 
Пробелы
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args[0] = "d:\\1.txt";
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();

        int count2 = 0;
        for (byte bb : b) {
            if (bb == ' ') {
                count2++;
            }
        }
        int res1 = count2 * 1000000 / b.length;
        double resault = (double) res1 / 10000;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(resault);
        //System.out.println(resault);
        System.out.println(format.toString());
    }
}

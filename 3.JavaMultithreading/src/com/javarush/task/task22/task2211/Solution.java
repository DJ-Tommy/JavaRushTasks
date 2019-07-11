package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String nameInputFile = args[0];
        String nameOutputFile = args[1];
        File file = new File(nameInputFile);
        InputStreamReader fileReader = new InputStreamReader(new FileInputStream(file));
        Charset win = Charset.forName("Windows-1251");
        byte[] inputBytes = new byte[(int)file.length()];
        fileReader.read(inputBytes);
        fileReader.close();
        String input = new String(inputBytes, win);


        Charset koi8 = Charset.forName("UTF8");


        String input = new String()
    }
}

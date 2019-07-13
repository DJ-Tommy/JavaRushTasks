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
        FileInputStream fileReader = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(nameOutputFile);
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        byte[] inputBytes = new byte[(int)file.length()];
        fileReader.read(inputBytes);
        fileReader.close();
        String input = new String(inputBytes, windows1251);
        inputBytes = input.getBytes(utf8);
        outputStream.write(inputBytes);
        outputStream.close();
    }
}

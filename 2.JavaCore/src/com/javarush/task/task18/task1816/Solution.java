package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        // 65-90, 97-122 ascii English letters
        int count = 0;
        for (byte bb : b) {
            if ((bb > 64 && bb < 91) || (bb > 96 && bb < 123)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

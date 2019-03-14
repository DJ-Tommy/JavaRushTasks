package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(name1)));
        BufferedReader file2 = new BufferedReader(new InputStreamReader(new FileInputStream(name2)));
        fileToList(file1, allLines);
        fileToList(file2, forRemoveLines);
        file1.close();
        file2.close();
        new Solution().joinData();
    }

    public static void fileToList(BufferedReader file, List<String> list) throws IOException{
        while (true) {
            String string = file.readLine();
            if (string == null) {
                break;
            }
            list.add(string);
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean isContain = true;
        for (String s : forRemoveLines) {
            if (!allLines.contains(s)) {
                isContain = false;
                break;
            }
        }
        if (isContain) {
            for (String s : forRemoveLines) {
                allLines.remove(s);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

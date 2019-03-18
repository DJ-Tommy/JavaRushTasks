package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = nameReader.readLine();
//        String fileName = "d:\\9.txt";
        nameReader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        StringBuilder builder = new StringBuilder();

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            builder.append(line);
        }
        reader.close();
        fileReader.close();

        ArrayList<String> list = new ArrayList<>();
        ArrayList<StringBuilder> listVlog = new ArrayList<>();
        int start = 0;
        String tag = args[0];
        StringBuilder tagString = new StringBuilder();

        for (int i = 0; i < builder.length(); i++) {
            if (start == 0 && i < builder.length() - tag.length() && builder.substring(i, i + tag.length() + 1).equals("<" + tag)) {
                tagString = new StringBuilder();
                listVlog = new ArrayList<>();
                tagString.append(builder.substring(i, i + tag.length() + 1));
                start = 1;
                i += tag.length();
                continue;
            }

            if (start > 0) {
                if (i < builder.length() - tag.length() && builder.substring(i, i + tag.length() + 1).equals("<" + tag)) {
                    start++;
                    listVlog.add(new StringBuilder());
                    for (int j = 0; j < start - 1; j++) {
                        listVlog.get(j).append(builder.substring(i, i + tag.length() + 1));
                    }
                    tagString.append(builder.substring(i, i + tag.length() + 1));
                    i += tag.length();
                    continue;
                } else if (i < builder.length() - tag.length() - 2 && builder.substring(i, i + tag.length() + 3).equals("</" + tag + ">")) {
                    tagString.append(builder.substring(i, i + tag.length() + 3));
                    for (int j = 0; j < start - 1; j++) {
                        listVlog.get(j).append(builder.substring(i, i + tag.length() + 3));
                    }
                    i += tag.length() + 2;
                    if (start == 1) {
                        start--;
                        list.add(tagString.toString());
                        for (int j = listVlog.size() - 1; j >= 0; j--) {
                            list.add(listVlog.get(j).toString());
                        }
                    } else {
                        start--;
                    }
                    continue;
                } else if (i < builder.length() - tag.length() && !builder.substring(i, i + tag.length() + 1).equals("<" + tag)) {
                    tagString.append(builder.substring(i, i + 1));
                    if (start > 1) {
                        for (int j = 0; j < start - 1; j++) {
                            listVlog.get(j).append(builder.substring(i, i + 1));
                        }
                    }
                    continue;
                }
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

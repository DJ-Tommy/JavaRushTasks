package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
//        String name1 = "d:\\7.txt";
//        String name2 = "d:\\8.txt";
        reader.close();

        BufferedReader file1 = new BufferedReader(new FileReader(name1));
        BufferedReader file2 = new BufferedReader(new FileReader(name2));
        ArrayList<String> fileString1 = new ArrayList<>();
        ArrayList<String> fileString2 = new ArrayList<>();

        while (true) {
            String line1 = file1.readLine();
            String line2 = file2.readLine();
            if (line1 == null && line2 == null) {
                break;
            }
            if (line1 != null) {
                fileString1.add(line1);
            }
            if (line2 != null) {
                fileString2.add(line2);
            }
        }
        file1.close();
        file2.close();

        int first = 0;
        int second = 0;

        while (true) {
            if (first >= fileString1.size() && second >= fileString2.size()) {
                break;
            }

            if (first >= fileString1.size()) {
                lines.add(new LineItem(Type.ADDED, fileString2.get(second)));
                first++;
                second++;
                continue;
            }

            if (second >= fileString2.size()) {
                lines.add(new LineItem(Type.REMOVED, fileString1.get(first)));
                first++;
                second++;
                continue;
            }

            if (fileString1.get(first).equals(fileString2.get(second))) {
                lines.add(new LineItem(Type.SAME, fileString1.get(first)));
                first++;
                second++;
                continue;
            }

            if (++first < fileString1.size() && fileString1.get(first).equals(fileString2.get(second))) {
                lines.add(new LineItem(Type.REMOVED, fileString1.get(first - 1)));
                lines.add(new LineItem(Type.SAME, fileString1.get(first)));
                first++;
                second++;
            } else {
                lines.add(new LineItem(Type.ADDED, fileString2.get(second)));
                lines.add(new LineItem(Type.SAME, fileString2.get(++second)));
                second++;
            }
        }

        for (LineItem li : lines) {
            System.out.println(li.type + " " + li.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

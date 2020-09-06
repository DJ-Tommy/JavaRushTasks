package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new ArrayList<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            File[] tempList = new File(queue.poll()).listFiles();
            if (tempList != null) {
                for (File file : tempList) {
                    if (!file.isDirectory()) {
                        files.add(file.getAbsolutePath());
                    } else {
                        queue.offer(file.getAbsolutePath());
                    }
                }
            }
        }
        return files;

    }

    public static void main(String[] args) throws IOException {
        getFileTree("d:\\record\\192.168.10.15\\1");
    }
}

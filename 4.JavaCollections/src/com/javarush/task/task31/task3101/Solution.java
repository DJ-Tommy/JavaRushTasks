package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/* 
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File result = new File(resultFileAbsolutePath);
        if (FileUtils.isExist(result)) {
            FileUtils.renameFile(result, new File(result.getParent() + "/allFilesContent.txt"));
        } else {
            File allFilesContent = new File(result.getParent() + "/allFilesContent.txt");
        }
        List<File> files = getFileTree(path);
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        FileOutputStream fileOutputStream = new FileOutputStream(result.getParent() + "/allFilesContent.txt");
        for (File file : files) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();
            fileOutputStream.write(buffer);
            fileOutputStream.write("\n".getBytes());
        }
        fileOutputStream.close();
    }

    public static List<File> getFileTree(String root) throws IOException {
        List<File> files = new ArrayList<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            File[] tempList = new File(queue.poll()).listFiles();
            if (tempList != null) {
                for (File file : tempList) {
                    if (file.isFile() && file.length() <= 50) {
                        files.add(file);
                    }
                    if (file.isDirectory()) {
                        queue.offer(file.getAbsolutePath());
                    }
                }
            }
        }
        return files;
    }

}

package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        System.out.println("Запроси пользователя ввести полный путь архива с клавиатуры.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));
        zipFileManager.createZip(Paths.get(reader.readLine()));
        reader.close();
    }
}

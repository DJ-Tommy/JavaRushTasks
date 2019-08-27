package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter your name of archive and full path: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(reader.readLine()));
//        ZipFileManager zipFileManager = new ZipFileManager(Paths.get("d:\\1.zip"));
//        System.out.println("d:\\1.zip");
        System.out.println("Add the file for archiving: ");
        zipFileManager.createZip(Paths.get(reader.readLine()));
//        System.out.println("d:\\1.txt");
//        zipFileManager.createZip(Paths.get("d:\\1.txt"));
        reader.close();
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}

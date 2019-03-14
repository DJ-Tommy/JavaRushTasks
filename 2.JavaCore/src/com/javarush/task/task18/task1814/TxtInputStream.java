package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private static FileInputStream origin;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!(fileName.substring(fileName.length() - 4).toLowerCase()).equals(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
        origin = this;

    }

    public static void main(String[] args) throws IOException {

    }
}


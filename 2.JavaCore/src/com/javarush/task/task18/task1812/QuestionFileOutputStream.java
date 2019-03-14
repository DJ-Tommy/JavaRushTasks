package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream s;

    public QuestionFileOutputStream(AmigoOutputStream s) {
        this.s = s;
    }

    @Override
    public void flush() throws IOException {
        s.flush();
    }

    @Override
    public void write(int b) throws IOException {
        s.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        s.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        s.write(b,off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (reader.readLine().equals("Д")) {
            s.close();
        }
    }
}


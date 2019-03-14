package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface extends Runnable{

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        String content = "";
        Thread thread = new Thread(this);

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {

            return content;
        }

        /*@Override
        public void join() throws InterruptedException {
            thread.join();
        }

        @Override
        public void start() {
            thread.start();
        }*/

        @Override
        public void run() {
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(fullFileName));
                while (true) {
                    String line = fileReader.readLine();
                    if (line == null) {
                        break;
                    }
                    content += line + " ";
                }
                if (content.length() > 1) {
                    content = content.substring(0, content.length() - 1);
                }

            } catch (Exception e) {

            }


        }
    }



}

package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "d:\\2022.txt";
        String fileName1 = "d:\\2022-1.txt";
        Solution solution = new Solution(fileName);
        solution.writeObject("String String String");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName1));
        outputStream.writeObject(solution);
        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName1));
        solution = (Solution) inputStream.readObject();
        solution.writeObject("222222222");

    }
}

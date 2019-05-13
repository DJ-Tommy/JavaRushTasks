package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        solution.edges.add(new Solution());
        solution.edges.add(new Solution());
        solution.edges.add(new Solution());
        solution.edges.add(new Solution());
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d:\\2024.txt"));
        outputStream.writeObject(solution);
        outputStream.reset();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("d:\\2024.txt"));
        solution = (Solution) inputStream.readObject();
        System.out.println(solution);
    }
}

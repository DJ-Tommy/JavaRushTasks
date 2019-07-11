package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
        String fileName = "d:\\44.txt";
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String s = fileReader.readLine();
            if (s == null) {
                break;
            }
            stringBuilder.append(s + " ");
        }

        System.out.println(stringBuilder.toString());
        ArrayList<String> stringArray = new ArrayList<>();
        Collections.addAll(stringArray, stringBuilder.toString().split("\\s+"));
        System.out.println(stringArray);


        int numberOfLine = 0;
        while (true) {
            StringBuilder s = new StringBuilder();
            s.append(stringArray.get(numberOfLine)).reverse();
            boolean find = false;
            for (int i = numberOfLine + 1; i < stringArray.size(); i++) {
                if (s.toString().equals(stringArray.get(i))) {
                    Pair pair = new Pair();
                    pair.first = stringArray.get(numberOfLine);
                    pair.second = stringArray.get(i);
                    result.add(pair);
                    stringArray.remove(i);
                    stringArray.remove(numberOfLine);
                    find = true;
                    break;
                }
            }
            if (find) {
                continue;
            }
            if (++numberOfLine > stringArray.size() - 2) {
                break;
            }
        }
        for (Pair p: result) {
            System.out.println(p.first + " " + p.second);
            System.out.println(p);
        }

        System.out.println(stringArray);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

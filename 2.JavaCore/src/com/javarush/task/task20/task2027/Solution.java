package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same", "leo", "home", "sun", "same", "god", "red", "mo");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

        for (Word w : detectAllWords(crossword, "home", "same", "leo", "poeejj", "jjeeop", "same", "god", "red", "mo", "rov", "hj")) {
            System.out.println(w);
        }

    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> list = new ArrayList<>();
        int height = crossword.length;
        int weight = crossword[0].length;
        for (String text : words) {
            char[] chars = text.toCharArray();


            for (int i = 0; i < height; i++) {
                for (int j = 0; j < weight; j++) {
                    if ((char) crossword[i][j] == chars[0]) {
                        if (chars.length == 1) {
                            Word word = new Word(text);
                            word.setStartPoint(j, i);
                            word.setEndPoint(j, i);
                            list.add(word);
                        }
// ----------------------- left and right
                        if (j + chars.length <= weight) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i][j + y] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j + y, i);
                                    list.add(word);
                                }
                            }
                        }

                        if (j - chars.length >= -1) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i][j - y] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j - y, i);
                                    list.add(word);
                                }
                            }
                        }
// ---------------------- up and down
                        if (i + chars.length <= height) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i + y][j] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j, i + y);
                                    list.add(word);
                                }
                            }
                        }

                        if (i - chars.length >= -1) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i - y][j] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j, i - y);
                                    list.add(word);
                                }
                            }
                        }

// ----------------------- diagonally
                        if (j + chars.length <= weight && i + chars.length <= height) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i + y][j + y] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j + y, i + y);
                                    list.add(word);
                                }
                            }
                        }

                        if (j - chars.length >= -1 && i - chars.length >= -1) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i - y][j - y] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j - y, i - y);
                                    list.add(word);
                                }
                            }
                        }

                        if (j + chars.length <= weight && i - chars.length >= -1) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i - y][j + y] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j + y, i - y);
                                    list.add(word);
                                }
                            }
                        }

                        if (j - chars.length >= -1 && i + chars.length <= height) {
                            for (int y = 1; y < chars.length; y++) {
                                if (crossword[i + y][j - y] != chars[y]) {
                                    break;
                                }
                                if (y == chars.length - 1) {
                                    Word word = new Word(text);
                                    word.setStartPoint(j, i);
                                    word.setEndPoint(j - y, i + y);
                                    list.add(word);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

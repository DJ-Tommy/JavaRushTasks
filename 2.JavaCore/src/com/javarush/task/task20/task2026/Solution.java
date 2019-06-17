package com.javarush.task.task20.task2026;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    int ii = i;
                    int jj = j;
                    a[i][j] = 3;
                    while (true) {
                        if (jj + 1 < a.length && a[ii][jj + 1] == 1) {
                            jj++;
                            a[ii][jj] = 3;
                        } else {
                            if (ii + 1 < a.length && a[ii + 1][j] == 1) {
                                jj = j;
                                ii++;
                                a[ii][jj] = 3;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
//        printArrays(a);
        return count;
    }

    public static void printArrays(byte[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[][] DEGREE = new long[10][20];

    static {
        for (int i = 0; i < 20; i++) {
            DEGREE[0][i] = 0;
            DEGREE[1][i] = 1;
        }

        for (int j = 2; j < 10; j++) {
            for (int i = 0; i < 20; i++) {
                long value = (long) j;
                for (int k = 0; k < i; k++) {
                    value *= (long) j;
                }
                DEGREE[j][i] = value;
            }
        }

        System.out.println(DEGREE[0][9] + " " + DEGREE[1][15] + " " + DEGREE[3][4] + " " + DEGREE[2][10] + " " + DEGREE[9][15]);
    }

    public static long[] getNumbers(long N) {
        if (N < 1) { return null; }

        for (long i = 1; i < N; i++) {
            ArrayList<Integer> num = toArrayListFromNumber(i);

            if (isTrueNumber(num)) {
                long res = armstrongValue(num);

                ArrayList<Integer> list = toArrayListFromNumber(res);
                if (list.size() == num.size() && res < N) {
                    long res1 = armstrongValue(list);
                    if (res == res1) {
                        System.out.println(num.toString() + res);
                    }
                }
            }
        }



        long[] result = null;
        return result;
    }

    public static boolean isTrueNumber(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 1) {
            return true;
        }
        for (int i = 1; i < arrayList.size(); i++) {
            if (i == 1 && arrayList.get(1) == 0) {
                continue;
            }
            if (arrayList.get(i) < arrayList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> toArrayListFromNumber(long N) {
        ArrayList<Integer> num = new ArrayList<>();
        long j = N;
        int k;
        while (true) {
            k = (int) j % 10;
            num.add(0, k);
            j = j / 10;
            if (j <= 0) {
                break;
            }
        }
        return num;
    }

    public static Long armstrongValue(ArrayList<Integer> list) {
        long res = 0;
        for (int s : list) {
            res += DEGREE[s][list.size() - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        getNumbers(9223372036854775807L);
    }
}

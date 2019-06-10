package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[][] DEGREE = new long[11][20];
    public static ArrayList<byte[]> listZZ = new ArrayList<>();

    static {
        // Данный массив предназначен просто для информации обо всех числах армстронга и не используется в решении
        long[] armstrongValues = new long[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
                548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
                472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
                42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L,
                4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
                1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L
        };

        for (int i = 0; i < 20; i++) {
            DEGREE[0][i] = 0;
            DEGREE[1][i] = 1;
        }

        for (int j = 2; j < 11; j++) {
            for (int i = 0; i < 20; i++) {
                long value = (long) j;
                for (int k = 0; k < i; k++) {
                    value *= (long) j;
                }
                DEGREE[j][i] = value;
            }
        }

        byte[] zero = {0};
        listZZ.add(zero);

        for (byte c = 1; c <= 19; c++) {
            byte numberOfDigit = c;
            byte[] matrixMassive = new byte[numberOfDigit];
            for (int i = numberOfDigit - 1; i >= 0; i--) {
                matrixMassive[i] = 0;
            }
            while (true) {
                byte k = 0;
                byte countZero = 0;
                byte countNine = 0;
                if (matrixMassive[0] == 9 && matrixMassive[numberOfDigit - 1] == 9) {
                    break;
                }
                for (int i = numberOfDigit - 1; i >= 0; i--) {
                    if (matrixMassive[i] < 9) {
                        matrixMassive[i]++;
                        if (k > 0) {
                            for (int j = numberOfDigit - 1; j > numberOfDigit - k - 1; j--) {
                                matrixMassive[j] = matrixMassive[i];
                            }
                        }
                        break;
                    } else {
                        k++;
                    }
                    if (matrixMassive[i] == 0) {
                        countZero++;
                    }

                    if (matrixMassive[i] == 9) {
                        countNine++;
                    }

                }
//                System.out.println(Arrays.toString(matrixMassive));

                if (countNine < 3 && countZero < 3) {
                    listZZ.add(Arrays.copyOf(matrixMassive, matrixMassive.length));
                }
            }
        }
//        System.out.println("Array contain      " + listZZ.size() + " variants");

    }

    public static long[] getNumbers(long N) {
        ArrayList<Long> res = new ArrayList<>();
        byte nn = numberOfDigit(N);
        int count = 0;
        for (byte[] b : listZZ) {
            if (b.length > nn) {
                break;
            }
            long vV = armstrongValue(b);
            if (numberOfDigit(vV) == b.length) {
                ArrayList<Byte> result = toArrayListFromNumber(vV);
                boolean bul = true;
                for (byte q = 0; q < b.length; q++) {
                    if (result.get(q) != b[q]) {
                        bul = false;
                        break;
                    }
                }
                if (bul == true) {
                    count++;
                    if (vV < N) {
                        res.add(vV);
                    }
                }
            }
        }
        long [] r1 = new long[res.size()];
        res.sort(Comparator.naturalOrder());
        for (int i = 0; i < r1.length; i++) {
            r1[i] = res.get(i);
        }
//        System.out.println("Count for numbers: " + count);

        return r1;
    }

    public static byte numberOfDigit(long value) {
        for (byte i = 1; i < 19; i++) {
            if (value < DEGREE[10][i - 1]) {
                return i;
            }
        }
        return 19;
    }

    public static ArrayList<Byte> toArrayListFromNumber(long N) {
        ArrayList<Byte> num = new ArrayList<>();
        long j = N;
        byte k;
        while (true) {
            k = (byte) (j % 10);
            num.add(0, k);
            j = j / 10;
            if (j <= 0) {
                break;
            }
        }
        num.sort(Comparator.naturalOrder());
        return num;
    }

    public static Long armstrongValue(byte[] b) {
        long res = 0;
        for (byte s : b) {
            res += DEGREE[s][b.length - 1];
        }
        return res;
    }


    public static void main(String[] args) {
        long executionTime = System.currentTimeMillis();
//        getNumbers( 9223372036854775807L);
        getNumbers(92233720000036877L);
        executionTime = System.currentTimeMillis() - executionTime;
        System.out.println("Program execution: " + executionTime / 1000 + " sec and " + executionTime % 1000 + " millisec");

    }
}




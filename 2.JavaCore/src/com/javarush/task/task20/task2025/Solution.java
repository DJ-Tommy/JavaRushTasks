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

        System.out.println(DEGREE[0][9] + " " + DEGREE[1][15] + " " + DEGREE[3][4] + " " + DEGREE[2][10] + " " + DEGREE[9][15]);
    }

    public static long[] getNumbers(long N) {
        generateMatrixOfValue();
        numberOfDigit(N);
        int count = 0;
        for (byte[] b : listZZ) {
            for (int ii = 0; ii < b.length; ii++) {
//                System.out.print(b[ii] + " ");
            }
            System.out.println();
            long vV = armstrongValue(b);
            if (numberOfDigit(vV) == b.length) {
                count++;
                ArrayList<Byte> result = toArrayListFromNumber(vV);
                System.out.println(result.toString());
                boolean bul = true;
                for (byte q = 0; q < b.length; q++) {
                    if (result.get(q) != b[q]) {
                        bul = false;
                        break;
                    }
                }
                if (bul == true) {
//                    System.out.println(b.toString());
                }
            }
        }
        System.out.println("Count for numbers: " + count);
        return null;
    }

    public static byte numberOfDigit(long value) {
        for (byte i = 1; i < 20; i++) {
            if (value / 10 < DEGREE[10][i]) {
                return (byte)(i + 2);
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

    public static void generateMatrixOfValue() {
        for (byte c = 1; c < 20; c++) {
            byte numberOfDigit = c;
            byte[] matrixMassive = new byte[numberOfDigit];
            for (int i = numberOfDigit - 1; i >= 0; i--) {
                matrixMassive[i] = 0;
            }
            while (true) {
                byte k = 0;
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

                }
                listZZ.add(matrixMassive);
//                listZZ.add(Arrays.copyOf(matrixMassive, matrixMassive.length));
//                System.out.println(listZZ.get(listZZ.size() - 1).toString());

            }
        }
        System.out.println("Array contain      " + listZZ.size() + " variants");


    }

    public static void main(String[] args) {
        long executionTime = System.currentTimeMillis();
        getNumbers(9223372036854775807L);
        executionTime = System.currentTimeMillis() - executionTime;
        System.out.println("Program execution: " + executionTime / 1000 + " sec and " + executionTime % 1000 + " millisec");

    }
}

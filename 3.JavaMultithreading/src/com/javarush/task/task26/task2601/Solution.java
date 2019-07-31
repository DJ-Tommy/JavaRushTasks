package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int median;
        if (array.length % 2 != 0) {
            median = array[array.length / 2];
        } else {
            median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (Math.abs(array[j] - median) > Math.abs(array[j + 1] - median)) {
                    int start = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = start;
                }
            }
        }
        return array;
    }
}

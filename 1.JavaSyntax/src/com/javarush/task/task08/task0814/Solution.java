package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        for (Iterator<Integer> i = set.iterator(); i.hasNext(); ) {
            int e = i.next();
            if (e > 10) {
                i.remove();
            }
        }
        return set;

    }

    public static void main(String[] args) {

    }
}

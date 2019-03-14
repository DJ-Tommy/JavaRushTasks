package com.javarush.task.task07.task0716;

import java.util.ArrayList;
import java.util.Iterator;

/*
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {

        Iterator<String> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            String s = listIterator.next();
            if (s.contains("р") && !s.contains("л")) listIterator.remove();
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).contains("р") && list.get(i).contains("л")) {
                list.add(i, list.get(i));
                i++;
            }
        }
        //напишите тут ваш код
        return list;
    }
}
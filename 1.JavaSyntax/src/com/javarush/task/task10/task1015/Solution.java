package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        list1.add("wergtr erhrthertyrt  nnr");
        list1.add("wergt2345r erhrthe2234425rtyrt  nnr");
        list1.add("wergtr erhrth2345ertyrt  nnr");
        list1.add("wergtr er34324hrthertyrt  nnr");
        list2.add("wergtr erhrthertyrt  nnr");
        list2.add("wergt2345r erhrthe2234425rtyrt  nnr");
        list2.add("wergtr erhrth2345ertyrt  nnr");
        list2.add("wergtr er34324hrthertyrt  nnr");
        list3.add("wergtr erhrthertyrt  nnr");
        list3.add("wergt2345r erhrthe2234425rtyrt  nnr");
        list3.add("wergtr erhrth2345ertyrt  nnr");
        list3.add("wergtr er34324hrthertyrt  nnr");



        ArrayList<String>[] lists = (ArrayList<String>[]) new ArrayList[3];

        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list2;

        return lists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
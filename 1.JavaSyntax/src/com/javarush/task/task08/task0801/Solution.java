package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> val = new HashSet<>();
        val.add("арбуз");
        val.add("банан");
        val.add("вишня");
        val.add("груша");
        val.add("дыня");
        val.add("ежевика");
        val.add("женьшень");
        val.add("земляника");
        val.add("ирис");
        val.add("картофель");

        for (String s : val) {
            System.out.println(s);
        }

    }
}

package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>()
    {{
        put(0.1111, "kroertrtrn");
        put(0.11211, "krortrktern");
        put(0.122111, "krorern");
        put(0.111431, "kroeffgrn");
        put(0.154111, "kroqwern");
    }};


    public static void main(String[] args) {

        System.out.println(labels);
    }
}

package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> text = new ArrayList<>();
        text.add("dgrfgghtref");
        text.add("dgrfgghtref");
        text.add("dgrfgghtref");
        text.add("dgrfgghtref");
        text.add("dgrfgghtref");
        System.out.println(text.size());
        for (String s : text) {
            System.out.println(s);
        }
        //напишите тут ваш код
    }
}

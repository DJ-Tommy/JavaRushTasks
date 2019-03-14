package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> people = new HashMap<>();
        people.put("LastName", "FirstName");
        people.put("LastName", "FirstName");
        people.put("LastName", "FirstName");
        people.put("LastName1", "FirstName");
        people.put("LastName4", "FirstName");
        people.put("LastName5", "FirstName");
        people.put("LastName6", "FirstName");
        people.put("LastName7", "FirstName");
        people.put("LastName8", "FirstName");
        people.put("LastName9", "FirstName");

        return people;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}

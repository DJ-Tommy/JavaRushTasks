package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> person = new HashMap<>();
        person.put("LastName0", "Name1");
        person.put("LastName1", "Name2");
        person.put("LastName2", "Name3");
        person.put("LastName3", "Name2");
        person.put("LastName4", "Name4");
        person.put("LastName5", "Name5");
        person.put("LastName6", "Name6");
        person.put("LastName7", "Name1");
        person.put("LastName8", "Name7");
        person.put("LastName9", "Name8");
        return person;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        HashSet<String> set = new HashSet<>(map.values());
        for (String s : set) {
            int count = 0;
            for (Map.Entry<String, String> m : map.entrySet()) {
                if (s.equals(m.getValue())) {
                    count++;
                }

            }
            if (count > 1) {
                removeItemFromMapByValue(map, s);
            }
        }
        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

        removeTheFirstNameDuplicates(createMap());
    }
}

package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("LastName", 1500);
        map.put("LastName1", 400);
        map.put("LastName2", 900);
        map.put("LastName3", 100);
        map.put("LastName4", 1500);
        map.put("LastName5", 100);
        map.put("LastName6", 1500);
        map.put("LastName7", 100);
        map.put("LastName8", 1500);
        map.put("LastName9", 5500);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue() < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

        removeItemFromMap(createMap());
    }
}
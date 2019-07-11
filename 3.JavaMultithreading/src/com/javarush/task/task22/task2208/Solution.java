package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> pairs = new HashMap<>();
        pairs.put("name", "Ivanov");
        pairs.put("country", "Ukraine");
        pairs.put("city", "Kiev");
        pairs.put("age", null);
        System.out.println(getQuery(pairs));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Map.Entry<String, String> m : params.entrySet()) {
            if (m.getValue() == null) {
                continue;
            }
            if (count == 0) {
                stringBuilder.append(m.getKey() + " = '" + m.getValue() + "'");
                count++;
            } else {
                stringBuilder.append(" and " + m.getKey() + " = '" + m.getValue() + "'");
            }
        }
        return stringBuilder.toString();
    }
}

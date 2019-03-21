package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties s = new Properties();
        s.putAll(properties);
        s.store(outputStream, "");
        /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (Map.Entry<String, String> m : properties.entrySet()) {
            String result = m.getKey() + " : " + m.getValue() + "\n";
            writer.write(result);
        }
        writer.close();*/
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        properties.clear();
        Properties l = new Properties();
        l.load(inputStream);
        for (String name : l.stringPropertyNames()) {
            properties.put(name, l.getProperty(name));
        }
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        properties.clear();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] str = line.split(" : ");
            if (str.length == 2) {
                properties.put(str[0], str[1]);
            }
        }
        reader.close();*/
    }

    public static void main(String[] args) throws Exception {

        /*properties.put("website", "https://ru.wikipedia.org/");
        properties.put("param1", "true");
        properties.put("param2", "123456789 123456778");
        properties.put("param3", "zebra");
        properties.put("param4", "pedestrian");
        Solution s = new Solution();
        s.save(new FileOutputStream("d:\\12.txt"));
        s.fillInPropertiesMap();
        for (Map.Entry<String, String> m : properties.entrySet()) {
            System.out.println("key = " + m.getKey() + "   parameter = " + m.getValue());
        }*/
    }
}

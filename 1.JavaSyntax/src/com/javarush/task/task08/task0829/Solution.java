package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
        HashMap<String, String> addresses = new HashMap<>();
        String s;
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                s = reader.readLine();
                break;
            }
            String family = reader.readLine();




            addresses.put(city, family);
        }

        // Read the house number
//        int houseNumber = Integer.parseInt(reader.readLine());

        //String city = reader.readLine();
            System.out.println(addresses.get(s));
    }
}

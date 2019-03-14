package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String id = "";
        String productName = "";
        String price = "";
        String quantity = "";
        if (args.length == 0) {
            return;
        }
        String key = args[0];
        if (key.equals("-d")) {
            id = args[1];
        } else if (key.equals("-u")) {
            id = args[1];
            productName = args[2];
            price = args[3];
            quantity = args[4];
        } else {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> list = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        boolean e = true;

        while (true) {
            String line = fileReader.readLine();
            if (line == null) {
                break;
            }
            int getId = Integer.parseInt(line.substring(0, 8).trim());
            if (e && key.equals("-d") && Integer.parseInt(id) == getId) {
                e = false;
                continue;
            }

            if (e && key.equals("-u") && Integer.parseInt(id) == getId) {
                e = false;
                id += "        ";
                id = id.substring(0, 8);
                productName += "                               ";
                productName = productName.substring(0, 30);
                price += "          ";
                price = price.substring(0, 8);
                quantity += "    ";
                quantity = quantity.substring(0, 4);
                list.add(id + productName + price + quantity);
                continue;
            }
            list.add(line);
        }
        fileReader.close();


        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        int count = 0;
        for (String s : list) {
            count++;
            if (count < list.size()) {
                writer.write(s + "\n");
            } else {
                writer.write(s);
            }
        }
        writer.close();

    }
}

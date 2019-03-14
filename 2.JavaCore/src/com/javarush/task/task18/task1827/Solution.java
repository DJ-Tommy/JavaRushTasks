package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[0].equals("-c")) {
            return;
        }
        String key = args[0];
//        String key = "-c";
        String productName = args[1];
//        String productName = "qwertyqwertasasasa";
        String price = args[2];
//        String price = "43.8456734253253";
        String quantity = args[3];
//        String quantity = "987654321";



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "d:\\5.txt";
        reader.close();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        int maxId = 0;

        while (true) {
            String line = fileReader.readLine();
            if (line == null) {
                break;
            }
            int getId = Integer.valueOf(line.substring(0, 8).trim());
            if (maxId < getId) {
                maxId = getId;
            }
        }
        fileReader.close();
        maxId++;
        String id = "" + maxId;

        id += "        ";
        id = id.substring(0, 8);

        productName += "                               ";
        productName = productName.substring(0, 30);
        price += "          ";
        price = price.substring(0, 8);
        quantity += "    ";
        quantity = quantity.substring(0, 4);



        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        String result = "\n" + id + productName + price + quantity;
        writer.write(result);
        writer.close();

    }
}

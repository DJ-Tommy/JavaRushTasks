package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] str = line.split(" ");
            String name = "";
            for (int i = 0; i < str.length - 3; i++) {
                name += str[i];
                if (i < str.length - 4) {
                    name += " ";
                }
            }
            String date = str[str.length - 1] + " " + str[str.length - 2] + " " + str[str.length - 3];
            Date birthDate = new SimpleDateFormat("y M d", Locale.ENGLISH).parse(date);

            PEOPLE.add(new Person(name, birthDate));
        }
        fileReader.close();
        reader.close();

        for (Person p : PEOPLE) {
            System.out.println(p.getName() + " " + p.getBirthDate());
        }
    }
}

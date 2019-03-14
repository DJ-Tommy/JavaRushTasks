package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length == 0) {
            return;
        }

        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[3])));
            } else {
                allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[3])));
            }
            System.out.println(allPeople.size() - 1);
        }

        if (args[0].equals("-u")) {
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[4]));
            if (args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            } else {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }
        }

        if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }

        if (args[0].equals("-i")) {
            int id = Integer.parseInt(args[1]);
            String sex;
            SimpleDateFormat date = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
            if (allPeople.get(id).getSex() == Sex.FEMALE) {
                sex = "ж";
            } else sex = "м";
            System.out.println(allPeople.get(id).getName() + " " + sex + " " + date.format(allPeople.get(id).getBirthDate()));
        }
    }
}

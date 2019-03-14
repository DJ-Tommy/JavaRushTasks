package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    int number = (args.length - 1) / 3;
                    for (int i = 0; i < number; i++) {
                        if (args[2 + i * 3].equals("м")) {
                            creation(args[1 + i * 3], Sex.MALE, new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[3 + i * 3]), allPeople.size());
                        } else if (args[2 + i * 3].equals("ж")){
                            creation(args[1 + i * 3], Sex.FEMALE, new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[3 + i * 3]), allPeople.size());
                        }
                    }
                }
                    break;

            case "-u":
                synchronized (allPeople) {
                    int number1 = (args.length - 1) / 4;
                    for (int i = 0; i < number1; i++) {
                        int id = Integer.parseInt(args[1 + i * 4]);
                        String name = args[2 + i * 4];
                        Sex sex;
                        Date date = new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[4 + i * 4]);
                        if (args[3 + i * 4].equals("м")) {
                            sex = Sex.MALE;
                        } else {
                            sex = Sex.FEMALE;
                        }
                        updates(id, name, sex, date);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        deletion(Integer.parseInt(args[i]));
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        print(Integer.parseInt(args[i]));
                    }
                }
                break;
            default:
                synchronized (allPeople) {
                    throw new Exception("Неверные входные параметры");
                }
        }
    }

    public static void deletion(int id) {
        allPeople.get(id).setName(null);
        allPeople.get(id).setBirthDate(null);
        allPeople.get(id).setSex(null);
    }

    public static void updates(int id, String name, Sex sex, Date birthDay) {
        allPeople.get(id).setName(name);
        allPeople.get(id).setBirthDate(birthDay);
        allPeople.get(id).setSex(sex);
    }

    public static void creation (String name, Sex sex, Date birthDay, int num) {
        if (sex == Sex.MALE) {
            allPeople.add(Person.createMale(name, birthDay));
        } else {
            allPeople.add(Person.createFemale(name, birthDay));
        }
        System.out.println(num);
    }

    public static void print(int id) {
        String sex;
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        if (allPeople.get(id).getSex() == Sex.FEMALE) {
            sex = "ж";
        } else sex = "м";
        System.out.println(allPeople.get(id).getName() + " " + sex + " " + date.format(allPeople.get(id).getBirthDate()));

    }
}

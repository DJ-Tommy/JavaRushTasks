package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
        list.add(new Human("GrandPa1", true, 72));
        list.add(new Human("GrandPa2", true, 71));
        list.add(new Human("GrandMa1", false, 70));
        list.add(new Human("GrandMa2", false, 69));
        list.add(new Human("Father", true, 40, list.get(0), list.get(2)));
        list.add(new Human("Mother", false, 39, list.get(1), list.get(3)));
        list.add(new Human("Child1", false, 19, list.get(4), list.get(5)));
        list.add(new Human("Child2", true, 13, list.get(4), list.get(5)));
        list.add(new Human("Child3", false, 23, list.get(4), list.get(5)));

        for (Human human : list) {
            System.out.println(human.toString());
        }

        // напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        // напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}
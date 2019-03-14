package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("child1", true, 5);
        Human child2 = new Human("child2", true, 3);
        Human child3 = new Human("child3", false, 9);
        Human mother = new Human("mother", false, 30);
        Human father = new Human("father", true, 60);
        Human gf1 = new Human("gf1", true, 90);
        Human gf2 = new Human("gf2", true, 91);
        Human gm1 = new Human("gm1", false, 92);
        Human gm2 = new Human("gm2", false, 93);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        gf1.children.add(mother);
        gm1.children.add(mother);
        gf2.children.add(father);
        gm2.children.add(father);
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(gf1.toString());
        System.out.println(gm1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm2.toString());


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}

package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name1 = reader.readLine();
        Cat cat1 = new Cat(name1);
        String name2 = reader.readLine();
        Cat cat2 = new Cat(name2);
        String name3 = reader.readLine();
        Cat cat3 = new Cat(name3, null, cat1);
        String name4 = reader.readLine();
        Cat cat4 = new Cat(name4, cat2, null);
        String name5 = reader.readLine();
        Cat cat5 = new Cat(name5, cat4, cat3);
        String name6 = reader.readLine();
        Cat cat6 = new Cat(name6, cat4, cat3);

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
        System.out.println(cat5);
        System.out.println(cat6);

    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            String f = father == null ? ", no father" : ", father is " + father.name;
            String m = mother == null ? ", no mother" : ", mother is " + mother.name;

            return "The cat's name is " + name + m + f;

        }
    }

}

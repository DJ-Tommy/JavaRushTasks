package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private long height;
        private double weight;
        private short zip;


        public Human(double weight) {
            this.weight = weight;
        }

        public Human(long height) {
            this.height = height;
        }

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, long height) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }

        public Human(String name, int age, boolean sex, long height, double weight) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, int age, boolean sex, long height, double weight, short zip) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.zip = zip;
        }
    }
}

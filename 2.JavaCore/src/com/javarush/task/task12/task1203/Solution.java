package com.javarush.task.task12.task1203;

/* 
Кесарю — кесарево
*/

public class Solution {
    public static void main(String[] args) {
        Cat pet1 = new Cat();
        Cat cat = pet1.getChild();

        Dog pet2 = new Dog();
        Dog dog = pet2.getChild();
    }

    public static class Pet {
        public Pet getChild() {
            return new Pet();
        }
    }

    public static class Cat extends Pet {
        public Cat getChild() {
            return new Cat();
        }
    }

    public static class Dog extends Pet {
        public Dog getChild() {
            return new Dog();
        }
    }
}

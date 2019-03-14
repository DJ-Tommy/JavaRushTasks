package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

import javax.naming.StringRefAddr;

public class Cat {
    String name;
    int age;
    int weight;
    String address;
    String color;

    public void initialize(String name) {
        this.name = name;
        age = 3;
        weight = 3;
        color = "multicolor";
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        color = "multicolor";
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 3;
        color = "multicolor";
    }

    public void initialize(int weight, String color) {
        age = 3;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String address) {
        age = 3;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}

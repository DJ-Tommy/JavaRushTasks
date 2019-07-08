package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;
            A a = (A) o;
            return i == a.i &&
                    j == a.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Object clone() throws CloneNotSupportedException{
            throw  new CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            B b = (B) o;
            return name.equals(b.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }



    public static void main(String[] args) throws CloneNotSupportedException {
        C c = new C(10, 10, "String");
        System.out.println(c);
        C clone = (C) c.clone();
        System.out.println(clone);
    }

    @Override
    public C clone() throws CloneNotSupportedException {
        C clone = new C(clone().getI(), clone().getJ(), clone().getName());

        return clone;
    }



}

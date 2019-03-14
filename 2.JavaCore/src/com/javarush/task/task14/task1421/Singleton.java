package com.javarush.task.task14.task1421;

final class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

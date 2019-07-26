package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> listCause = new ArrayList<>();
        listCause.add(e);

        while (true) {
            try {
                if (listCause.get(0).getCause() != null) {
                    listCause.add(0, listCause.get(0).getCause());
                } else {
                    break;
                }
            } catch (Exception e1) {
                break;
            }
        }

        for (Throwable cause : listCause) {
            System.out.println(cause);
        }
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}

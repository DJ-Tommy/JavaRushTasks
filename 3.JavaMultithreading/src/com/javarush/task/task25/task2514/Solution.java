package com.javarush.task.task25.task2514;

import java.util.Random;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < new Random().nextInt(42); i++) {
            new Thread(new Solution.YieldRunnable(new Random().nextInt(4444))).start();
        }
    }
}

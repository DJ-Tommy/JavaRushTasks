package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        lock.lock();
        if (lock.tryLock()) {
            try {
                ifLockIsFree();
            } catch (Exception e) {

            }
            lock.unlock();
        } else {
            try {
                ifLockIsBusy();
            } catch (Exception e) {

            }
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }

    public void ifLockIsFree() {
        actionIfLockIsFree();
    }

    public void ifLockIsBusy() {
        actionIfLockIsBusy();
    }
}

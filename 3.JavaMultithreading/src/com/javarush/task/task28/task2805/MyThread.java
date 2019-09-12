package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger priority = new AtomicInteger(0);


    public MyThread() {
        super();
        this.setPriority(valueOfPriority().get());
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(valueOfPriority().get());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(valueOfPriority().get());
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(valueOfPriority().get());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(valueOfPriority().get());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(valueOfPriority().get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(valueOfPriority().get());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(valueOfPriority().get());
    }

    public AtomicInteger valueOfPriority() {
        int max;

        if (this.getThreadGroup() == null) {
            max = MAX_PRIORITY;
        } else {
            max = this.getThreadGroup().getMaxPriority();
        }

        priority.incrementAndGet();
        AtomicInteger atomicInteger = new AtomicInteger();
            if (priority.get() >= MAX_PRIORITY) {
                atomicInteger.set(max);
                priority.set(0);
            } else {
                atomicInteger.set(priority.get());
            }
        return atomicInteger;
    }
}

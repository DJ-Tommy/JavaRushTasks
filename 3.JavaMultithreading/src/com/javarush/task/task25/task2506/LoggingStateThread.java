package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        super.run();
        Thread.State state = null;
        while (true) {
            if (state != thread.getState()) {
                state = thread.getState();
                System.out.println(thread.getState());
                if (thread.getState() == State.TERMINATED) {
                    break;
                }
            }
        }
        interrupt();
    }
}

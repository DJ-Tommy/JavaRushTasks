package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {

    public StringForSecondThreadTooShortException(Throwable cause) {
        super(cause);
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}

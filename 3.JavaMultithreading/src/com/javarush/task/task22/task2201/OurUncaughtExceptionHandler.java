package com.javarush.task.task22.task2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        String s;
        s = String.format(string, t.getName(), e.getMessage(), e.getMessage());
        return s;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        String s;
        s = String.format(string, t.getName(), e.getStackTrace()[0], e.getMessage());
        return s;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        String s;
        s = String.format(string, t.getName(), e, e.getMessage());
        return s;
    }
}


package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] texts = message.split(":");
            if (texts.length < 2) {
                return;
            }
            String name = texts[0];
            message = message.substring(name.length() + 2);
            Calendar date = new GregorianCalendar();
            SimpleDateFormat dateFormat;

            if (message.equals("дата")) {
                dateFormat = new SimpleDateFormat("d.MM.YYYY");
            } else if (message.equals("день")) {
                dateFormat = new SimpleDateFormat("d");
            } else if (message.equals("месяц")) {
                dateFormat = new SimpleDateFormat("MMMM");
            } else if (message.equals("год")) {
                dateFormat = new SimpleDateFormat("YYYY");
            } else if (message.equals("время")) {
                dateFormat = new SimpleDateFormat("H:mm:ss");
            } else if (message.equals("час")) {
                dateFormat = new SimpleDateFormat("H");
            } else if (message.equals("минуты")) {
                dateFormat = new SimpleDateFormat("m");
            } else if (message.equals("секунды")) {
                dateFormat = new SimpleDateFormat("s");
            } else {
                return;
            }
            sendTextMessage("Информация для " + name + ": " + dateFormat.format(date.getTime()));
        }
    }
}


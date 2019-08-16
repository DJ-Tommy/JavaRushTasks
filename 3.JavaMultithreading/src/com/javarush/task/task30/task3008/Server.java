package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        int serverPort = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Сервер запущен");
        } catch (IOException e) {
//            System.out.println(e.getMessage());
        }

        while (true) {
            try {
                new Handler(serverSocket.accept()).start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                try {
                    serverSocket.close();
                } catch (Exception e1) {

                } finally {
                    break;
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (ConcurrentMap.Entry<String, Connection> map : connectionMap.entrySet()) {
            try {
                map.getValue().send(message);
            } catch (IOException e) {
                System.out.println(map.getKey() + " не смогли отправить сообщение.");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message messageSend = new Message(MessageType.NAME_REQUEST);

            while (true) {
                connection.send(messageSend);
                Message message = connection.receive();

                if (message.getType() == MessageType.USER_NAME
                        && message.getData() != null && message.getData() != ""
                        && !connectionMap.containsKey(message.getData())) {
                    connection.send(new Message(MessageType.NAME_ACCEPTED, "Имя было принято"));
                    connectionMap.put(message.getData(), connection);
                    return message.getData();
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {

            for (ConcurrentMap.Entry<String, Connection> map : connectionMap.entrySet()) {
                if (!map.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, map.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

            }
        }
    }

}

package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {

    public static void main(String[] args) {

        Operation operation = null;

        while (true) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);

            } catch (WrongZipFileException e1) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e2) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
            if (operation == Operation.EXIT) {
                break;
            }
        }
    }

    public static Operation askOperation() throws IOException {
        String text = "Выберите операцию:\n" +
                Operation.CREATE.ordinal() + " - упаковать файлы в архив\n" +
                Operation.ADD.ordinal() + " - добавить файл в архив\n" +
                Operation.REMOVE.ordinal() + " - удалить файл из архива\n" +
                Operation.EXTRACT.ordinal() + " - распаковать архив\n" +
                Operation.CONTENT.ordinal() + " - просмотреть содержимое архива\n" +
                Operation.EXIT.ordinal() + " - выход";
        ConsoleHelper.writeMessage(text);
        int number = ConsoleHelper.readInt();
        for (Operation operation : Operation.values()) {
            if (operation.ordinal() == number) {
                return operation;
            }
        }
        return null;

    }
}

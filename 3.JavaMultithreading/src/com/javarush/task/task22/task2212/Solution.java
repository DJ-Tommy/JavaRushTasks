package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.length() < 10 || telNumber.length() > 17 || telNumber.matches(".*([a-z]|[A-Z]).*")) {
            return false;
        }
        if (!telNumber.matches("\\+?\\d*\\(?\\d*\\)?\\d*-*\\d*-*\\d*")) {
            return false;
        }
        String digits = telNumber.replaceAll("\\D", "");
        if (telNumber.substring(0, 1).equals("+") && digits.length() != 12) {
            return false;
        }
        if (!telNumber.substring(0, 1).equals("+") && digits.length() != 10) {
            return false;
        }

        if (telNumber.matches("\\+?\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("3456789012"));
    }
}

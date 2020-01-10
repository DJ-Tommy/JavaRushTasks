package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number1 = new Number(NumberSystemType._6, "05543210");
        Number result1 = convertNumberToOtherNumberSystem(number1, NumberSystemType._2);
        System.out.println(result1);    //expected error

        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._16, "0abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected error

        number = new Number(NumberSystemType._16, "abcdefabcdefg");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected error
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
        int system = number.getNumberSystem().getNumberSystemIntValue();
        String value = number.getDigit();
        /*if (system <= 10) {
            if (!value.matches("[1-" + (system - 1) + "][0-" + (system - 1) + "]*")) {
                System.out.println("Number is " + value + " but is not the " + system + " System");
//                throw new NumberFormatException();
            }
        } else if (system == 16) {
            if (!value.matches("[1-9a-fA-F][0-9a-fA-F]*")) {
                System.out.println("Number is " + value + " but is not the " + system + " System");
//                throw new NumberFormatException();
            }
        }*/

        /*if (system == expectedNumberSystem.getNumberSystemIntValue()) {
            return number;
        }*/
        BigInteger result;
        try {
            result = new BigInteger(value, system);
        } catch (Exception e) {
            throw new NumberFormatException();
        }
        return new Number(expectedNumberSystem, result.toString(expectedNumberSystem.getNumberSystemIntValue()));
    }
}

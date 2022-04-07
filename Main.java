package com.company;
import java.io.IOException;
import java.util.Scanner;
import java.lang.String;
import java.lang.Exception;
public class Main {
    public static void  main(String[] args) throws Exception {
        String[] input = NumInput();  //  объявляем массив для ввода с числами и операцией

        int num1 = getInt(input[0].trim());  // возврат элемента по индексу 1 элемент
        int num2 = getInt(input[1].trim());  // возврат элемента по индексу 2 элемент

        String NumOperation = input[2];        // выходим на операцию

           int result = calc(num1, num2, NumOperation); // вычисление

           System.out.println(result);  // вывод
        for (int i=0; i<100; i++){       // вызываем main несколько 100 раз
            Main.main(args);
        }

    }

    public static String[] NumInput() throws IOException {                   // ввод
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String input = "";       // для блока условий

            if (scanner.hasNextLine()) {       // hasNextLine() - это метод класса Java Scanner, который используется для проверки наличия другой строки во входных данных этого сканера
                input = scanner.nextLine();   // nextLine() читает до конца текущей строки (символа перевода строки или конца потока) и возвращает всё, что было в этой строке.
            } else {
                System.out.println("Ошибка:");
                NumInput();
            }

            String NumOperation = getNumOperation(input);   // отправляем ввод на определение операции
            if (NumOperation.equals("")) {                  // Сравнивает эту строку с указанным объектом. Результат имеет значение true тогда и только тогда, когда аргумент не равен null и представляет собой строковый объект, представляющий ту же последовательность символов, что и этот объект.
                System.out.println("Ошибка");
                NumInput();
            } else {
                String[] expression = input.split("[+-/*]");              // иначе, если из метода пришла операция, то разбиваем строку в массив по одной из 4 операций
                return new String[]{expression[0], expression[1], NumOperation};
               
            }                                                                   // так как в реглярных выражениях знаки операций могут быть метасимволами , то экранируем https://ru.stackoverflow.com/questions/726198/Как-правильно-экранировать-метасимволы-в-регулярных-выражения

        try {
            return NumInput();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // если не получилось, то новый массив

        return new String[0];
    }

    public static String getNumOperation(String NumOperation) {                 // Определяем операцию с помощью регулярных выражений  https://javarush.ru/groups/posts/regulyarnye-vyrazheniya-v-java
        String result = "";
        if (NumOperation.matches("\\w+\\s*\\+\\s*\\w*")) {             // "+" экранируем
            result = "+";
        } else if (NumOperation.matches("\\w+\\s*-\\s*\\w*")) {        // "-" экранируем
            result = "-";
        } else if (NumOperation.matches("\\w+\\s*/\\s*\\w*")) {        // "/" экранируем
            result = "/";
        } else if (NumOperation.matches("\\w+\\s*\\*\\s*\\w*")) {      // "*" экранируем
            result = "*";
        }
        return result;
    }

    public static int getInt(String num) throws Exception {
        int result = 0;
        boolean numB = false;
        if (num.matches("\\d*")) {          // определяем арабские 0-9  *
            result = Integer.parseInt(num);

            if (result > 10) { throw new Exception("Exception");
            //    System.out.println( result + " " + "больше 10, введите число в интервале от 1 до 10");
            } else if (result < 1) {throw new Exception("Exception");
                // System.out.println( result + " " + "меньше 1, введите число в интервале от 1 до 10");
            }

        } else {
           //boolean numB = numB();
            result = convertRToA(num);

        }
        return result;


    }
    /*public static boolean numB(String a, String b) {
        if boolean result = a.regionMatches(0, b, 0, 1);

            return true;
        else
            return false;
    }*/
    // исключение - внештатная обработка данных с прерыванием  работы программы, не является ошибкой , можно обработываться также с помощью If


    public static char getNumOperation() {
        System.out.println("Введите операцию:");
        Scanner scanner = new Scanner(System.in);
        char NumOperation;
        if (scanner.hasNext()) {
            NumOperation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка");
            scanner.next();
            NumOperation = getNumOperation();
        }
        return NumOperation;
    }

    public static int calc(int num1, int num2, String NumOperation) {
        int result;

        switch (NumOperation) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
            default -> {
                System.out.println("Ошибка");
                return 0;
            }
        }
        return result;

    }

    public static int convertRToA(String a) {         //римские в арабские
        int result = 0;
        switch (a) {
            case "I" -> {
                result = 1;
                break;
            }
            case "II" -> {
                result = 2;
                break;
            }
            case "III" -> {
                result = 3;
                break;
            }
            case "IV" -> {
                result = 4;
                break;
            }
            case "V" -> {
                result = 5;
                break;
            }
            case "VI" -> {
                result = 6;
                break;
            }
            case "VII" -> {
                result = 7;
                break;
            }
            case "VIII" -> {
                result = 8;
                break;
            }
            case "IX" -> {
                result = 9;
                break;
            }
            case "X" -> {
                result = 10;
                break;
            }
            default -> System.out.println("Ошибка ввода римских цифр");
        }
        return result;

    }
    public static String convertAToR(int b) {    // арабские в римские
        String result = " ";
        switch (b) {
            case 1 -> {
                result = "II";
                break;
            }
            case 2 -> {
                result = "II";
                break;
            }
            case 3 -> {
                result = "III";
                break;
            }
            case 4 -> {
                result = "IV";
                break;
            }
            case 5 -> {
                result = "V";
                break;
            }
            case 6 -> {
                result = "VI";
                break;
            }
            case 7 -> {
                result = "VII";
                break;
            }
            case 8 -> {
                result = "VIII";
                break;
            }
            case 9 -> {
                result = "IX";
                break;
            }
            case 10 -> {
                result = "X";
                break;
            }
            default -> System.out.println(" Ошибка ввода арабских цифр ");
        }
        return result;
    }
}




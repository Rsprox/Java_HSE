package com.company;

import com.sun.org.apache.regexp.internal.RE;

/*
    Строки
 */
public class Main {

    public static void main(String[] args) {
        String str = ""; // упрощённое создание
        String strNew = new String(""); // стандартное через класс

        String str_1 = "молоко";
        String str_2 = "молоко";
        System.out.println(str_1==str_2); // true т.к. будут ссылаться на один и тот же участок памяти

        String str_3 = "молоко";
        String str_4 = new String("молоко");
        System.out.println(str_3==str_4); // false т.к. это разные ссылки на объекты в памяти

        System.out.println(str_3.equals(str_4)); // true !использовать только такой вариант

        /*
            String s = null;
            System.out.println(s.equals("asd")); // NullPointerException
            // можно добавить проверку - if (s != null && s.equals("some_string"))
            // либо вывернуть условие "some_string".equals(s)
        */

        System.out.println('р'-'н'); //str1.compareTo(STR2) - лексикографиечкое сранение строк

        // проверить является ли стркоа палиндромом
        String strIn = "А роза упала на лапу Азора";
        System.out.println(isPalindrome(strIn));

        }

        public static boolean isPalindrome(String str){
            // яляется ли строка палиндромом
            str = str.toLowerCase().replace('ё', 'е').
                    replace('й', 'и').replace(" ", "");
            System.out.println(str);
            for (int i = 0; i < str.length()/2; i++) {
                if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                    return false;
                }
            }
            return true;
        }
}

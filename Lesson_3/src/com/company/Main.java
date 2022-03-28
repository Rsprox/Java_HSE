package com.company;

import java.util.Scanner;

/*
Пользователь вводит натуральное число.
▪ Если число четное, то необходимо разделить его
пополам.
▪ Если нечетное – умножить на 3, прибавить 1 и
разделить пополам.
Повторить перечисленные действия с вновь
полученным числом
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
/*        Scanner sc = new Scanner(System.in);
        System.out.println("Введите натуральное число: ");

        while (!sc.hasNextInt()){
            System.out.println("Неверный ввод! Введите натуральное число (пример: 1, 2, 3, 4...)");
            sc.next();
        }

        int i = sc.nextInt();
        int iter = 0;

        while (i!=1) {
            if ((i % 2) == 0) {
                i /= 2;
            } else {
                i = (i * 3 + 1) / 2;
            }
            iter++;
            System.out.printf("Текущее значение - %d\n", i);
        }
        System.out.printf("Итераций - %d, Итоговое число - %d", iter, i);*/

        java.util.Random rnd = new java.util.Random();

        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
            array[i] = rnd.nextInt(100);

        for (int i = 0; i < array.length; i++)
            System.out.printf("array[%d]=%d\n",i,array[i]);

        char[] suits = {'\u2660', '\u2665', '\u2663', '\u2666'};
        String[] values = {"6", "7", "8", "9", "10", "В", "Д", "К", "Т"};

        String[] cards = new String[36];

        int count = 0;

        for (char suit : suits) {
            for (String value : values) {
                cards[count++] = suit + value;
            }
        }

        System.out.println(java.util.Arrays.toString(cards));


        /*
        найти какой год по восточному календарю: Крыса, зелёный; Петух, красный
         */
        String[] animals = {"Крыса", "Корова", "Тигр", "Заяц", "Дракон", "Змея",
                "Лошадь", "Овца", "Обезьяна", "Петух", "Собака", "свинья"};

        String[] colors = {"зеленый", "красный", "желтый",
                "белый", "черный"};

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите год:");
        int n = sc.nextInt(); // вычисляемый год

        System.out.printf("Год - %s, %s\n", animals[(n -4) % 12], colors[(n - 4) % 10 / 2]);



    }
}

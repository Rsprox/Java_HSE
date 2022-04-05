package com.company;

import java.util.Scanner;

/*
    Методы
 */
public class Main {
    // яляется ли число простым
    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num ; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // вывод треугольника Паскаля
    public static void printPascalTriangle(int num) {
        int[] prevRow = {1};
        for (int i = 0; i < num; i++) {
            int[] row = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || i == j)
                    row[j] = 1;
                else
                    row[j] = prevRow[j - 1] + prevRow[j];
                System.out.printf("%4d", row[j]);
            }
            System.out.println();
            prevRow = row;
        }
    }

    // рекурсивный вывод треугольника Паскаля -- взять из презентации
    public static void recursivePrintPascalTriangle(int num) {


    }

    // вычисление текущего значения ячейки
    static int Pascal(int row, int column) {
        return 1;
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int inNumber = sc.nextInt();*/

        //проверка на Простое число
        /*System.out.println(isPrime(inNumber));*/

        //вывод треугольника Паскаля
        /*printPascalTriangle(inNumber);*/

        //рекурсивный вывод треугольника Паскаля
        /*recursivePrintPascalTriangle(inNumber);*/

        //двумерный массив
/*        int[][] arr = {{30, 5}, {0, 1}, {10, 30, 20}};
        printArray(arr);*/

        //цикл foreach
        int[] arr_each = new int[] {1, 2, 3, 5, 6, 7};

        //заполнить массив змейкой
        snakeArray();
    }

    private static void snakeArray() {
        //заполнить массив змейкой
        int rownum = 3, colnum = 4;
        int[][] mass = new int[3][4];

        int c = 0;
        for (int i = 0; i < colnum; i++) {
            if (i%2==0) {
                for (int j = 0; j < rownum; j++) {
                    mass[j][i] = ++c;
                }
            } else {
                for (int j = rownum-1; j >=  0; j--) {
                    mass[j][i] = ++c;
                }
            }
        }
        printArray(mass);
    }

    private static void printArray(int[][] mass) {
        // печать массива целых чисел int[]
        for (int[] ints : mass) {
            for (int anInt : ints) {
                System.out.printf("%4d", anInt);
            }
            System.out.println();
        }
    }
}

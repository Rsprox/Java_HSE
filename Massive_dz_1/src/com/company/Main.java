package com.company;

import java.util.Random;

/*
    Используя датчик случайных чисел, заполнить массив из двадцати элементов неповторяющимися числами.
 */
public class Main {

    //Заполнить массив неповторяющимися случайными числами
    public static void fillIntMassiveRandom(int[] inArr, int maxInt){
        Random rnd = new Random();
        for (int i = 0; i < inArr.length; i++) {
            int num = rnd.nextInt(maxInt);
            if (!exist(num, inArr)){
                inArr[i] = num;
            } else {
                int count = 0;
                do {
                    if (count == 200) {
                        System.out.println("Ошибка! Не удалось получить неповторяющее число за 200 итераций. Программа остановлена.");
                        System.exit(2);
                    }
                    num = rnd.nextInt(maxInt);
                    count++;
                } while (exist(num, inArr));
                inArr[i] = num;
            }
        }
    }

    //сществет ли число в массиве
    public static boolean exist(int num, int[] inArr){
        for (int i : inArr) {
            if (num==i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] randomInts = new int[20];
        fillIntMassiveRandom(randomInts, 100); // maxInt граница диапазона чисел
        System.out.println(java.util.Arrays.toString(randomInts));

    }
}

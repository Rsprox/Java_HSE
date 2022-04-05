package com.company;

/*
    Дан массив ненулевых целых чисел.
    Определить, сколько раз элементы массива при просмотре от его начала меняют знак.
    Например, в массиве 10, –4, 12, 56, –4, –89 знак меняется 3 раза.
 */
public class Main {


    public static void main(String[] args) {
        int[] intMass = {-10, 4, -12, 56, -4, -89, 10, -1, 15}; // должно быть 7 раз

        int count = countSignChanges(intMass);
        System.out.println(count);
    }

    // сколько раз изменился знак в элементах массива от начала
    // из условия - в массиве нет нулевых элементов!
    public static int countSignChanges(int[] intMass) {
        int count = 0;
        boolean lastSign = (intMass[0] > 0);
        for (int i = 1; i < intMass.length; i++) {
            boolean currSign = (intMass[i] > 0);
            if (lastSign != currSign){
                count++;
                lastSign = currSign;
            }
        }
        return count;
    }
}

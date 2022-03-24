package com.company;

import java.util.Scanner;

/*
    Ветвление, цикл for, ввод значений из консоли
    Задачка вывода правильного окончания при перечислении Коров[а|ы]
 */

public class Main {

    public static void main(String[] args) {
        double a = 1000;
        double b = 0.0001;

        //BigDecimal aB = new BigDecimal(0.0001);

        double c = (Math.pow((a+b),2) - (a*a + 2*a*b)) / Math.pow(b,2);

        System.out.println(String.format("a = %f, b = %f, c = %f", a,b,c));

        int i = 10;
        System.out.println(10 != 5);

        {
            System.out.println(i);
            boolean x = true;
        }

        // System.out.println(x); -- область видимости блока -> x не видн снаружи

        /* double x, y, r = 1;
        System.out.print("x = ");
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        System.out.print("y = ");
        y = sc.nextDouble();

        if ((Math.pow(x,2) + Math.pow(y,2)) <= r) {
            System.out.println("Inside circle!");
        } else {
            System.out.println("Outside circle!");
        }


        if (((Math.pow(x,2) + Math.pow(y,2)) <= r) && x >= 0) {
            System.out.println("Inside half-circle!");
        } else {
            System.out.println("Outside half-circle!");
        }

        switch ((int)x) {
            case 1:
                System.out.println("olo 1");
                break;
            case 10:
                System.out.println("olo 2");
                break;
        } */

        int n = 25;
        /* System.out.print("n = ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); */

        for (int z = 1; z <= n; z+=2) {
            String result = "Коров";
            int lastDigit = z % 10, lastTwoDigits = z % 100;

            if (11 <= lastTwoDigits && lastTwoDigits <= 14)
                result = "Коров";
            else if (lastDigit == 1)
                result = "Корова";
            else if (2 <= lastDigit && lastDigit <= 4)
                result = "Коровы";



            System.out.printf("На лугу пасется %d %s.\n", z, result);
        }


    }

}

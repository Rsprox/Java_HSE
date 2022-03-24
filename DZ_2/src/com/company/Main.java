package com.company;

/*
    Вывести все возможные счастливые билеты
 */

public class Main {

    public static void main(String[] args) {
        int firstTicket = 1001; //первый возможный счастливый билет
        int lastTicket = 999999; //последний билет
        String formatString = String.format ("%%0%dd", 6); //формат строки с лидирующими нулями

        for (; firstTicket <= lastTicket; firstTicket++) {
            int leftSum = 0, rightSum = 0;

            for (int i = 1; i < 4; i++) {
                leftSum += ((firstTicket/100) / (int)Math.pow(10, i)) % 10;
                rightSum += ((firstTicket%1000) / (int)Math.pow(10, i-1)) % 10;
            }

            if (leftSum == rightSum) {
                String formattedString = String.format(formatString, firstTicket);
                System.out.println(formattedString);
            }
        }
    }
}

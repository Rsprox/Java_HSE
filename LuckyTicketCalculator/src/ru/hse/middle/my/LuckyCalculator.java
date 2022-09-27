package ru.hse.middle.my;

import java.util.Arrays;

public class LuckyCalculator {
    public static Ticket firstTicket;
    public static Ticket lastTicket;

    // дефолтный конструктор - 6-значные билеты
    public LuckyCalculator() {
        firstTicket = new Ticket("000000");
        lastTicket = new Ticket("999999");
    }

    // произвольное число знаков в билете
    public LuckyCalculator(int i) {
        firstTicket = new Ticket(String.format("%0" + i + "d", 0));
        lastTicket = new Ticket(fillStringWithNines(i));
    }

    private String fillStringWithNines(int i) {
        char[] cs = new char[i];
        Arrays.fill(cs, '9');
        String s = new String(cs);
        return s;
    }

    public Integer calculate() {
        int count = 1;
        Ticket thisTick = firstTicket;
        while (!thisTick.equals(lastTicket)){
            if (thisTick.isLucky()){
                count++;
            }
            thisTick = nextTicket(thisTick);
        }
        return count;
    }

    private Ticket nextTicket(Ticket ticket){
        String s = String.format("%0" + ticket.getValue().length() + "d", Integer.parseInt(ticket.getValue())+1);
        return new Ticket(s);
    }

}

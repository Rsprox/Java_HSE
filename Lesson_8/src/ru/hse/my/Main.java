package ru.hse.my;


/*
    Римские числа
 */

public class Main {

    public static void main(String[] args) {
        Roman r = new Roman("XIX");
        System.out.println(r.getInteger());

        Roman r1 = new Roman(2022);
        r1.setInteger(2999);
        System.out.println(r1.getInteger());
        System.out.println(r1.getRoman());
    }
}

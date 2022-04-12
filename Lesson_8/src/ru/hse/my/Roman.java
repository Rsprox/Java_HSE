package ru.hse.my;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Римские числа
public class Roman {
    private int intValue;
    private String romanValue;

    private static Map<String, Integer> romans = new HashMap<String, Integer>();
    private static LinkedHashMap<Integer, String> intRomans = new LinkedHashMap<Integer, String>();

    static {
        romans.put("M", 1000);
        romans.put("D", 500);
        romans.put("C", 100);
        romans.put("L", 50);
        romans.put("X", 10);
        romans.put("V", 5);
        romans.put("I", 1);

        intRomans.put(1000, "M");
        intRomans.put(900, "CM");
        intRomans.put(500, "D");
        intRomans.put(400, "CD");
        intRomans.put(100, "C");
        intRomans.put(90, "XC");
        intRomans.put(50, "L");
        intRomans.put(40, "XL");
        intRomans.put(10, "X");
        intRomans.put(9, "IX");
        intRomans.put(5, "V");
        intRomans.put(4, "IV");
        intRomans.put(1, "I");
    }

    Roman(Integer in) {
        this.intValue = in;
        this.romanValue = intToRoman(in);
    }

    Roman(String in) {
        this.romanValue = in;
        this.intValue = romanToInt(in);
    }

    // реализовать
    private String intToRoman(Integer intIn) {
        StringBuilder s = new StringBuilder();
        for (Integer i : intRomans.keySet()) {
            while (intIn >= i) {
                s.append(intRomans.get(i));
                intIn -= i;
            }
        }
        return s.toString();
    }

    // реализовтаь
    private Integer romanToInt(String strIn) {
        int result=0;

        for(int i=0; i < strIn.length(); i++)
        {
            char ch = strIn.charAt(i);      // текущий символ

            //Case 1
            if (i > 0 && romans.get(String.valueOf(ch)) > romans.get(String.valueOf(strIn.charAt(i-1))))
            {
                result += romans.get(String.valueOf(ch)) - 2 * romans.get(String.valueOf(strIn.charAt(i-1)));
            }

            // Case 2: добавляем значение к результату
            else
                result += romans.get(String.valueOf(ch));
        }

        return result;
    }

    public int getInteger() {
        return intValue;
    }

    public String getRoman() {
        return romanValue;
    }

    public void setInteger(int intValue) {
        this.intValue = intValue;
        this.romanValue = intToRoman(intValue);
    }

    public void setRoman(String romanValue) {
        this.romanValue = romanValue;
        this.intValue = romanToInt(romanValue);
    }
}

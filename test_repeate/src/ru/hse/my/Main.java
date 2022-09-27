package ru.hse.my;

public class Main {

    public static void main(String[] args) {
	// количество счасливых билетов
        int fristTicket = 1001;
        int lastTicket = 999999;
        int count = 0;

        for (int i = fristTicket; i <= lastTicket; i++) {
            String s = String.valueOf(i);
            int leadPart = 0;
            int lastPart = 0;
            switch (s.length()) {
                case 4:
                    leadPart = s.charAt(0) - '0';
                    lastPart = s.charAt(1) - '0' + s.charAt(2) - '0' + s.charAt(3) - '0';
                    break;
                case 5:
                    leadPart = s.charAt(0) - '0' + s.charAt(1) - '0';
                    lastPart = s.charAt(2) - '0' + s.charAt(3) - '0' + s.charAt(4) - '0';
                    break;
                case 6:
                    leadPart = s.charAt(0) - '0' + s.charAt(1) - '0' + s.charAt(2) - '0';
                    lastPart = s.charAt(3) - '0' + s.charAt(4) - '0' + s.charAt(5) - '0';
                    break;
            }
            if (lastPart == leadPart) {
                count++;
            }
        }

        System.out.println(count);

    }
}

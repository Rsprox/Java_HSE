package org.hse.course.tasks.data;

import org.hse.course.tasks.service.Visitor;

import java.util.Arrays;

/**
 * Интерфейс сущности Билет
 */
public interface Ticket {

    /**
     * Построитель экземпляров {@link Ticket}
     */
    interface TicketFactory {

        /**
         * @param number номер билета
         * @return экзумпляр {@link Ticket}
         */
        Ticket getInstance(int number);
    }

    /**
     * @return экземпляр {@link SixDigitsTicketFactoryImpl}
     */
    static TicketFactory getSixDigitsTicketFactory() {
        return new SixDigitsTicketFactoryImpl();
    }

    /**
     * @return экземпляр {@link EightDigitsFactoryImpl}
     */
    static TicketFactory getEightDigitsTicketFactory() {
        return new EightDigitsFactoryImpl();
    }

    /**
     * @return экземпляр {@link FourDigitsFactoryImpl}
     */
    static TicketFactory getFourDigitsTicketFactory() {
        return new FourDigitsFactoryImpl();
    }

    /**
     * Возвращает количество цифр в номере бидета
     *
     * @return количество цифр
     */
    int getDigitsQuantity();

    /**
     * @return Является ли билет счастливым?
     */
    default boolean isLucky() {
        int firstSum = 0, lastSum = 0;
        int[] digits = getDigits();
        for (int i = 0; i < getDigitsQuantity(); i++) {
            if (i < getDigitsQuantity() / 2) {
                firstSum += digits[i];
                continue;
            }

            lastSum += digits[i];
        }

        return lastSum == firstSum;
    }

    /**
     * Возвращает цифры номера билета
     * @return {@link int[]} цифр
     */
    private int[] getDigits() {
        int[] result = new int[getDigitsQuantity()];
        Arrays.fill(result, 0);

        for (int number = getNumber(), i = 0; number > 0; number = number / 10, i++) {
            result[i] = number % 10;
        }

        return result;
    }

    /**
     * @return номер билета
     */
    int getNumber();

    /**
     * Метод, принимающий посетителя
     *
     * @param visitor посетитель
     * @param <R>     результат работы метода
     * @return {@link R}
     */
    default <R> R accept(Visitor<Ticket, R> visitor) {
        return visitor.visit(this);
    }
}

/**
 * Реализация {@link Ticket.TicketFactory} для шестизначных билетов
 */
class SixDigitsTicketFactoryImpl implements Ticket.TicketFactory {

    /**
     * @param number номер билета
     * @return {@link SixDigitsTicketImpl}
     */
    @Override
    public Ticket getInstance(int number) {
        return new SixDigitsTicketImpl(number);
    }

    /**
     * Реализация {@link Ticket} для случая шестизначных билетов
     */
    static class SixDigitsTicketImpl implements Ticket {
        private static final int DIGITS_COUNT = 6;
        private final int ticketNumber;

        /**
         * @param ticketNumber номер билета
         */
        public SixDigitsTicketImpl(int ticketNumber) {
            if (ticketNumber < 0 || ticketNumber > 999999) {
                throw new IllegalArgumentException("Разрешены только положительные числа <1000000");
            }
            this.ticketNumber = ticketNumber;
        }

        @Override
        public int getNumber() {
            return this.ticketNumber;
        }

        @Override
        public int getDigitsQuantity() {
            return DIGITS_COUNT;
        }
    }
}

/**
 * Реализация {@link Ticket.TicketFactory} для восьмизначных билетов
 */
class EightDigitsFactoryImpl implements Ticket.TicketFactory {

    @Override
    public Ticket getInstance(int number) {
        return new EightDigitsTicketImpl(number);
    }

    /**
     * Реализация {@link Ticket} для случая восьмизначных билетов
     */
    static class EightDigitsTicketImpl implements Ticket {
        private static final int DIGITS_COUNT = 8;
        private final int ticketNumber;

        private EightDigitsTicketImpl(int ticketNumber) {
            this.ticketNumber = ticketNumber;
        }

        @Override
        public int getNumber() {
            return this.ticketNumber;
        }

        @Override
        public int getDigitsQuantity() {
            return DIGITS_COUNT;
        }
    }
}

/**
 * Реализация {@link Ticket.TicketFactory} для четырёхзначных билетов
 */
class FourDigitsFactoryImpl implements Ticket.TicketFactory {

    @Override
    public Ticket getInstance(int number) {
        return new FourDigitsTicketImpl(number);
    }

    /**
     * Реализация {@link Ticket} для случая четырёхзначных билетов
     */
    static class FourDigitsTicketImpl implements Ticket {
        private final int ticketNumber;

        private FourDigitsTicketImpl(int ticketNumber) {
            this.ticketNumber = ticketNumber;
        }

        @Override
        public int getDigitsQuantity() {
            return 4;
        }

        @Override
        public int getNumber() {
            return ticketNumber;
        }
    }
}

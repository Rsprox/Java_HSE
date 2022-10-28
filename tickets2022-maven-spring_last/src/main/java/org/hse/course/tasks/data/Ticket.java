package org.hse.course.tasks.data;

import lombok.*;
import lombok.experimental.Accessors;
import org.hse.course.tasks.service.Visitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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
     *
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

    default void print() {
        System.out.println(this);
    }

    default int setNumber(int number) {
        return number;
    }

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
 * Реализация {@link Ticket.TicketFactory} по умолчанию
 */
@Primary
@RequiredArgsConstructor
class DefaultFactoryImpl implements Ticket.TicketFactory {
    private final ApplicationContext applicationContext;

    @Getter(AccessLevel.PRIVATE)
    private final String ticketType;

    @Override
    public Ticket getInstance(int number) {
        var fourDigitsTicket = applicationContext.getBean(getTicketType(), DefaultTicketImpl.class);
        fourDigitsTicket.setTicketNumber(number);
        return fourDigitsTicket;
    }

    /**
     * Реализация {@link Ticket} для случая четырёхзначных билетов
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    static class DefaultTicketImpl implements Ticket {
        @Setter(AccessLevel.PACKAGE)
        private int ticketNumber;

        @Setter(AccessLevel.PACKAGE)
        @Getter(AccessLevel.PUBLIC)
        private int digitsQuantity;

        @Override
        public int getNumber() {
            return ticketNumber;
        }
    }
}

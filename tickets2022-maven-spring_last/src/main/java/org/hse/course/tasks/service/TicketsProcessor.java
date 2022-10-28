package org.hse.course.tasks.service;

import lombok.AccessLevel;
import lombok.Setter;
import org.hse.course.tasks.data.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Обработчик билетов.
 * Прошу обратить внимание: поменял методы getStrategy и setStrategy.
 * В нашем случае достаточно Visitor в качестве Стратегии
 */
public interface TicketsProcessor {
    /**
     * @return функция, возвращающая билет по его номеру
     */
    Function<Integer, Ticket> getTicketSupplier();

    /**
     * @return количество цифр в билете
     */
    Integer getDigitsQuantity();

    /**
     * @return название обработчика
     */
    String getName();

    Optional<Visitor<Ticket, Boolean>> getStrategy();

    void setStrategy(Visitor<Ticket, Boolean> strategy);

    default Boolean testTicketByNumber(Integer number) {
        return getOptional(number)
                .map(getTicketSupplier())
                .map(Ticket::isLucky)
                .orElse(Boolean.FALSE);
    }

    static <T> Optional<T> getOptional(T t) {
        if (t == null) {
            return Optional.empty();
        }

        return Optional.of(t);
    }

    /**
     * Возвращает результат обработки
     */
    default void process() {
        System.out.println(getCount());
    }

    /**
     * Возвращает количество счастливых билетов
     *
     * @return количество счастливых билетов
     */
    default long getCount() {
        var rightExclusive = (int) Math.pow(10, getDigitsQuantity());

        var visitor = getStrategy();

        Predicate<Ticket> isLucky = Ticket::isLucky;
        Predicate<Ticket> extraCondition = ticket -> visitor.map(ticket::accept).orElse(true);

        var result =
                IntStream
                        .range(0, rightExclusive)
                        .parallel()
                        .mapToObj(getTicketSupplier()::apply)
                        .filter(isLucky.and(extraCondition))
                        .count();
        return result;
    }
}

/**
 * Реализация {@link TicketsProcessor} для подсчёта количества шестизначных счастливых билетов
 */
class SixDigitTicketsProcessorImpl implements TicketsProcessor {
    private Visitor<Ticket, Boolean> strategy;

    @Autowired
    @Qualifier("sixDigitsTicketFactory")
    private Ticket.TicketFactory factory;

    @Setter(AccessLevel.PACKAGE)
    private Function<Integer, Ticket> ticketSupplier;

    @Override
    public Integer getDigitsQuantity() {
        return 6;
    }

    @Override
    public String getName() {
        return "Шестизначные билеты";
    }

    @Override
    public Optional<Visitor<Ticket, Boolean>> getStrategy() {
        return TicketsProcessor.getOptional(this.strategy);
    }

    @Override
    public void setStrategy(Visitor<Ticket, Boolean> strategy) {
        this.strategy = strategy;
    }

    public Function<Integer, Ticket> getTicketSupplier() {
        return factory::getInstance;
    }
}

/**
 * Реализация {@link TicketsProcessor} для подсчёта количества восьмизначных счастливых билетов
 */
class EightDigitsTicketsProcessorImpl implements TicketsProcessor {

    private Visitor<Ticket, Boolean> strategy;

    private Ticket.TicketFactory factory;

    @Autowired
    public void setFactory(@Qualifier("eightDigitsFactory") Ticket.TicketFactory factory) {
        this.factory = factory;
    }

    @Override
    public Function<Integer, Ticket> getTicketSupplier() {
        return factory::getInstance;
    }

    @Override
    public Integer getDigitsQuantity() {
        return 8;
    }

    @Override
    public String getName() {
        return "Восьмизначные билеты";
    }

    @Override
    public Optional<Visitor<Ticket, Boolean>> getStrategy() {
        return TicketsProcessor.getOptional(this.strategy);
    }

    @Override
    public void setStrategy(Visitor<Ticket, Boolean> strategy) {
        this.strategy = strategy;
    }

}

/**
 * Реализация {@link TicketsProcessor} для подсчёта количества четырёхзначных счастливых билетов
 */
class FourDigitsTicketsProcessorImpl implements TicketsProcessor {
    private final Ticket.TicketFactory factory;

    private Visitor<Ticket, Boolean> strategy;

    @Autowired
    public FourDigitsTicketsProcessorImpl(@Qualifier("fourDigitsFactory") Ticket.TicketFactory factory) {
        this.factory = factory;
    }

    @Override
    public Function<Integer, Ticket> getTicketSupplier() {
        return factory::getInstance;
    }

    @Override
    public Integer getDigitsQuantity() {
        return 4;
    }

    @Override
    public String getName() {
        return "Четырёхзначные билеты";
    }

    @Override
    public Optional<Visitor<Ticket, Boolean>> getStrategy() {
        return TicketsProcessor.getOptional(this.strategy);
    }

    @Override
    public void setStrategy(Visitor<Ticket, Boolean> strategy) {
        this.strategy = strategy;
    }

}

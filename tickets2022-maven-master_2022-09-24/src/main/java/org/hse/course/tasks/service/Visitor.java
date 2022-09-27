package org.hse.course.tasks.service;

import org.hse.course.tasks.data.Ticket;

/**
 * Интерфейс Посетитель
 * @param <T> тип объекта, который можно "посетить"
 * @param <R> тип результата работы метода {@link Visitor#visit(Object)}
 */
public interface Visitor<T, R> {
    static Factory<Ticket, Boolean> getEvenVisitorFactory() {
        return new EvenTicketVisitorFactory();
    }

    R visit(T item);

    interface Factory<T, R> {
        Visitor<T,R> getInstance();
    }
}

class EvenTicketVisitorFactory implements Visitor.Factory<Ticket, Boolean> {

    @Override
    public Visitor<Ticket, Boolean> getInstance() {
        return new EvenTicketVisitorImpl();
    }

    private static class EvenTicketVisitorImpl implements Visitor<Ticket, Boolean> {

        @Override
        public Boolean visit(Ticket item) {
            var modulo = item.getNumber() % 2;
            return modulo == 0;
        }
    }
}

class OddTicketVisitorFactory implements Visitor.Factory<Ticket, Boolean> {

    @Override
    public Visitor<Ticket, Boolean> getInstance() {
        return new OddTicketVisitorFactory.OddTicketVisitorImpl();
    }

    private class OddTicketVisitorImpl implements Visitor<Ticket, Boolean> {

        @Override
        public Boolean visit(Ticket item) {
            var modulo = item.getNumber() % 2;
            return modulo == 1;
        }

    }
}
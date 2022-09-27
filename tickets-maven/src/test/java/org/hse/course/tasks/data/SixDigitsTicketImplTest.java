package org.hse.course.tasks.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тесты для {@link SixDigitsTicketFactoryImpl}
 */
public class SixDigitsTicketImplTest {

    @Test
    public void testConstructorHappyPath() {
        //given
        int number = 100500;

        //when
        var ticket = new SixDigitsTicketFactoryImpl.SixDigitsTicketImpl(number);

        //then
        assertNotNull("Должно что-то вернуть", ticket);
        assertEquals("Билет шестизначный", 6, ticket.getDigitsQuantity());
        assertEquals("С нужным номером", 100500, ticket.getNumber());
    }

    /**
     * Проверяет работу конструктора при отрицательном входном значении
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegative(){
        //given
        int number = -100500;

        //when
        var ticket = new SixDigitsTicketFactoryImpl.SixDigitsTicketImpl(number);

        //then
    }

    /**
     * Проверяет работу конструктора при числе больше 999999
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorGreaterThenSixDigits(){
        //given
        int number = 1000000;

        //when
        var ticket = new SixDigitsTicketFactoryImpl.SixDigitsTicketImpl(number);

        //then
    }

    /**
     * Проверяет работу метода {@link Ticket#isLucky()}
     */
    @Test
    public void testLuckyTicket(){
        //given
        int lucky = 100001;
        int notLucky = 100222;

        //when
        var ticketLucky = new SixDigitsTicketFactoryImpl.SixDigitsTicketImpl(lucky);
        var ticketNotLucky = new SixDigitsTicketFactoryImpl.SixDigitsTicketImpl(notLucky);

        //then
        assertNotNull("Должно что-то вернуть", ticketLucky);
        assertEquals("Билет шестизначный", 6, ticketLucky.getDigitsQuantity());
        assertEquals("С нужным номером", 100001, ticketLucky.getNumber());
        assertTrue("Этот билет счастливый", ticketLucky.isLucky());

        assertNotNull("Должно что-то вернуть", ticketNotLucky);
        assertEquals("Билет шестизначный", 6, ticketNotLucky.getDigitsQuantity());
        assertEquals("С нужным номером", 100222, ticketNotLucky.getNumber());
        assertFalse("Этот билет счастливый", ticketNotLucky.isLucky());
    }
}
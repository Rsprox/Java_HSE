package org.hse.course.tasks.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class SixDigitsTicketFactoryImplTest {

    private Ticket.TicketFactory factory;

    @Before
    public void init() {
        factory = Ticket.getSixDigitsTicketFactory();
    }

    @After
    public void dispose() {
        factory = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetInstanceLessThanZero() {
        //given
        int number = -1;
        //when
        //then
        factory.getInstance(number);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetInstanceSevenDigits() {
        //given
        int number = 1000000;
        //when
        //then
        factory.getInstance(number);

    }

    @Test
    public void testGetInstanceHappyPath() {
        //given
        int number = 999999;

        Ticket mock = Mockito.mock(Ticket.class);

        Mockito.doNothing().when(mock).print();

        Mockito.doAnswer(invocation -> {
            System.out.println("This is mock");
            return null;
        }).when(mock).print();

        Mockito.when(mock.setNumber(any(Integer.class))).thenAnswer(invocationOnMock -> {
           Integer num = invocationOnMock.getArgument(0, Integer.class);
           return num;
        });

        Mockito.when(mock.setNumber(number)).thenReturn(number);

        //when
        Ticket ticket = factory.getInstance(number);
        //then
        Mockito.verify(mock, Mockito.never());
        assertNotNull("Результат вернулся", ticket);
        assertEquals("Номер билета соответствует", number, ticket.getNumber());
        assertTrue("Билет счастливый", ticket.isLucky());

    }

//    static class SixDigitsTicketImplMock extends SixDigitsTicketFactoryImpl.SixDigitsTicketImpl {
//
//        public void SixDigitsTicketMock(int ticketNumber) {
//            super(ticketNumber);
//        }
//
//        @Override
//        public int getNumber() {
//            return 1001;
//        }
//
//        @Override
//        public boolean isLucky() {
//            return true;
//        }
//    }

}
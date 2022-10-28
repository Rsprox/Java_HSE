package org.hse.course.tasks.service;

import org.hse.course.tasks.data.Ticket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация приложения Счастливый билет
 */
@Configuration
public class TicketServiceConfig {

    @Bean(name = "sixDigitTicketsProcessor")
    TicketsProcessor getSixDigitTicketsProcessor() {
        System.out.println("Bean sixDigitTicketsProcessor created!");
        return new SixDigitTicketsProcessorImpl();
    }

    @Bean(name = "eightDigitsTicketsProcessor")
    TicketsProcessor getEightDigitsTicketsProcessor() {
        System.out.println("Bean eightDigitsTicketsProcessor created!");
        return new EightDigitsTicketsProcessorImpl();
    }

    @Bean(name = "fourDigitsTicketsProcessor")
    TicketsProcessor getFourDigitsTicketsProcessor(@Qualifier("fourDigitsFactory") Ticket.TicketFactory factory) {
        System.out.println("Bean fourDigitsTicketsProcessor created!");
        return new FourDigitsTicketsProcessorImpl(factory);
    }
}

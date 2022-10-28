package org.hse.course.tasks.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TicketConfig {

    @Bean("fourDigitsTicket")
    @Scope("prototype")
    DefaultFactoryImpl.DefaultTicketImpl getFourDigitsTicket() {
        var ticket = new DefaultFactoryImpl.DefaultTicketImpl();
        return ticket.setDigitsQuantity(4);
    }

    @Bean("sixDigitsTicket")
    @Scope("prototype")
    DefaultFactoryImpl.DefaultTicketImpl getSixDigitsTicket() {
        return (new DefaultFactoryImpl.DefaultTicketImpl()).setDigitsQuantity(6);
    }

    @Bean("eightDigitsTicket")
    @Scope("prototype")
    DefaultFactoryImpl.DefaultTicketImpl getEightDigitsTicket() {
        return (new DefaultFactoryImpl.DefaultTicketImpl()).setDigitsQuantity(8);
    }

    @Bean("fourDigitsFactory")
    Ticket.TicketFactory getFourDigitsFactory(ApplicationContext context) {
        return new DefaultFactoryImpl(context, "fourDigitsTicket");
    }

    @Bean("sixDigitsTicketFactory")
    Ticket.TicketFactory getSixDigitsTicketFactory(ApplicationContext context) {
        return new DefaultFactoryImpl(context, "sixDigitsTicket");
    }

    @Bean("eightDigitsFactory")
    Ticket.TicketFactory getEightDigitsFactory(ApplicationContext context) {
        return new DefaultFactoryImpl(context, "eightDigitsTicket");
    }
}

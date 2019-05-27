package com.rcb.poc.saga.booking.aggregate;

import com.rcb.poc.saga.command.BookingCommand;
import com.rcb.poc.saga.event.BookingEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class BookingAggregate {

    @AggregateIdentifier
    public String bookingId;

    private String paymentId;

    public BookingAggregate(){
    }

    @CommandHandler
    public BookingAggregate(BookingCommand cmd) {
        System.out.println("Handler del command de DELETE del saga "+cmd.paymentId);
        apply(new BookingEvent(cmd.bookingId, cmd.paymentId));

    }

    @EventSourcingHandler
    protected void onMessage(BookingEvent bookingEvent) {
        this.bookingId = bookingEvent.bookingId;
        this.paymentId = bookingEvent.paymentId;
        System.out.println("Event paymentId "+ bookingId + " del saga "+ paymentId);
    }
}

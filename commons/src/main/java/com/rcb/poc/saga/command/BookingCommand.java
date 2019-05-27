package com.rcb.poc.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BookingCommand {

    @TargetAggregateIdentifier //generate routing key
    public String bookingId;

    public String paymentId;

    public BookingCommand(String bookingId, String paymentId) {
        this.bookingId = bookingId;
        this.paymentId = paymentId;
    }
}

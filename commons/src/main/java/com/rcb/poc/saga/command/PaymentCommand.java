package com.rcb.poc.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class PaymentCommand {

    @TargetAggregateIdentifier //generate routing key
    public String paymentId;

    public int quantity;

    public PaymentCommand(String paymentId, int quantity) {
        this.paymentId = paymentId;
        this.quantity = quantity;
    }
}

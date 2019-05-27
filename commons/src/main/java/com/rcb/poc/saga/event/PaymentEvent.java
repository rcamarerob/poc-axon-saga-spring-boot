package com.rcb.poc.saga.event;

public class PaymentEvent {

    public final String paymentId;

    public PaymentEvent(String updateId) {
        this.paymentId = updateId;
    }
}

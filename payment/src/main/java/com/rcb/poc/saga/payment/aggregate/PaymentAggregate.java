package com.rcb.poc.saga.payment.aggregate;

import com.rcb.poc.saga.command.PaymentCommand;
import com.rcb.poc.saga.event.PaymentEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PaymentAggregate {

    @AggregateIdentifier
    public String paymentId;

    public int quantity;

    public PaymentAggregate(){}
/*
    @EventSourcingHandler
    protected void on(PaymentEvent updatePolicyEvent){
        this.paymentId = updatePolicyEvent.paymentId;
    }*/

    @CommandHandler
    protected PaymentAggregate(PaymentCommand cmd) {
        this.paymentId = cmd.paymentId;
        this.quantity = 190;
        System.out.println("Handler del command de update "+cmd.paymentId);
        apply(new PaymentEvent(cmd.paymentId));
    }

}

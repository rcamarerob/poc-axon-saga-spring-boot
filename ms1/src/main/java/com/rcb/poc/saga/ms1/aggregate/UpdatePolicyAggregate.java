package com.rcb.poc.saga.ms1.aggregate;

import com.rcb.poc.saga.command.UpdatePolicyCommand;
import com.rcb.poc.saga.event.UpdatePolicyEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class UpdatePolicyAggregate {

    @AggregateIdentifier
    public String updateId;

    public int quantity;

    public UpdatePolicyAggregate(){}
/*
    @EventSourcingHandler
    protected void on(UpdatePolicyEvent updatePolicyEvent){
        this.updateId = updatePolicyEvent.updateId;
    }*/

    @CommandHandler
    protected UpdatePolicyAggregate(UpdatePolicyCommand cmd) {
        this.updateId = cmd.updateId;
        this.quantity = 190;
        System.out.println("Handler del command de update "+cmd.updateId);
        apply(new UpdatePolicyEvent(cmd.updateId));
    }

}

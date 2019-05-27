package com.rcb.poc.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdatePolicyCommand {

    @TargetAggregateIdentifier //generate routing key
    public String updateId;

    public int quantity;

    public UpdatePolicyCommand(String updateId, int quantity) {
        this.updateId = updateId;
        this.quantity = quantity;
    }
}

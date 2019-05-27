package com.rcb.poc.saga.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeletePolicyCommand {

    @TargetAggregateIdentifier //generate routing key
    public String deleteId;

    public String sagaId;

    public DeletePolicyCommand(String deleteId, String sagaId) {
        this.deleteId = deleteId;
        this.sagaId = sagaId;
    }
}

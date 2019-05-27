package com.rcb.poc.saga.ms2.aggregate;

import com.rcb.poc.saga.command.DeletePolicyCommand;
import com.rcb.poc.saga.event.DeletePolicyEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class DeletePolicyAggregate {

    @AggregateIdentifier
    public String deleteId;

    private String updateId;

    public DeletePolicyAggregate(){
    }

    @CommandHandler
    public DeletePolicyAggregate(DeletePolicyCommand cmd) {
        System.out.println("Handler del command de DELETE del saga "+cmd.sagaId);
        apply(new DeletePolicyEvent(cmd.deleteId, cmd.sagaId));

    }

    @EventSourcingHandler
    protected void onMessage(DeletePolicyEvent deletePolicyEvent) {
        this.deleteId = deletePolicyEvent.deleteId;
        this.updateId = deletePolicyEvent.updateId;
        System.out.println("Event updateId "+ deleteId + " del saga "+ updateId);
    }
}

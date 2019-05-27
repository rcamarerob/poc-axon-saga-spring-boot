package com.rcb.poc.saga.ms1;

import com.rcb.poc.saga.command.DeletePolicyCommand;
import com.rcb.poc.saga.event.DeletePolicyEvent;
import com.rcb.poc.saga.event.UpdatePolicyEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;
import java.util.UUID;

@Saga
public class SagaManagement {

    @Inject
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "updateId")
    public void on(UpdatePolicyEvent evt) {
        System.out.println("Starting SAGA "+evt.updateId);
        SagaLifecycle.associateWith("updateId", evt.updateId);

        String idDelete = UUID.randomUUID().toString();
        commandGateway.send(new DeletePolicyCommand(idDelete, evt.updateId));
    }

    @SagaEventHandler(associationProperty = "updateId")
    public void handle(DeletePolicyEvent evt) {
        System.out.println("Deleting "+evt.deleteId);
        //SagaLifecycle.associateWith("updateId", evt.updateId);

        SagaLifecycle.end();
        System.out.println("END SAGA "+evt.updateId);
    }
}

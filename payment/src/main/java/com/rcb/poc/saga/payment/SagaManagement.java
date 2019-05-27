package com.rcb.poc.saga.payment;

import com.rcb.poc.saga.command.BookingCommand;
import com.rcb.poc.saga.event.BookingEvent;
import com.rcb.poc.saga.event.PaymentEvent;
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
    @SagaEventHandler(associationProperty = "paymentId")
    public void on(PaymentEvent evt) {
        System.out.println("Starting SAGA "+evt.paymentId);
        //SagaLifecycle.associateWith("paymentId", evt.paymentId);

        String idDelete = UUID.randomUUID().toString();
        commandGateway.send(new BookingCommand(idDelete, evt.paymentId));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(BookingEvent evt) {
        System.out.println("Deleting "+evt.bookingId);

        SagaLifecycle.end();
        System.out.println("END SAGA "+evt.paymentId);
    }
}

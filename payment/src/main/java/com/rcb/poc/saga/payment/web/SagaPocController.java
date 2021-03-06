package com.rcb.poc.saga.payment.web;

import com.rcb.poc.saga.command.PaymentCommand;
import org.axonframework.commandhandling.callbacks.LoggingCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SagaPocController {

    private CommandGateway commandGateway;

    @Autowired
    public SagaPocController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/saga")
    public ResponseEntity launchSaga() {

        commandGateway.send(new PaymentCommand(UUID.randomUUID().toString(), 1000), LoggingCallback.INSTANCE);

        return ResponseEntity.ok(null);
    }
}
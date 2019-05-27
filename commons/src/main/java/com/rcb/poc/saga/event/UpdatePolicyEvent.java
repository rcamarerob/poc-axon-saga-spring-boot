package com.rcb.poc.saga.event;

public class UpdatePolicyEvent {

    public final String updateId;

    public UpdatePolicyEvent(String updateId) {
        this.updateId = updateId;
    }
}

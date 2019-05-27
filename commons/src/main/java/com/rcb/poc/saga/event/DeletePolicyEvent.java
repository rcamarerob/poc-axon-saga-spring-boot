package com.rcb.poc.saga.event;

public class DeletePolicyEvent {

    public final String deleteId;

    public final String updateId;

    public DeletePolicyEvent(String deleteId, String updateId){
        this.deleteId = deleteId;
        this.updateId = updateId;
    }
}

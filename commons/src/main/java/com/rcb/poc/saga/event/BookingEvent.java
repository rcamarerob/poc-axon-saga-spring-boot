package com.rcb.poc.saga.event;

public class BookingEvent {

    public final String bookingId;

    public final String paymentId;

    public BookingEvent(String deleteId, String updateId){
        this.bookingId = deleteId;
        this.paymentId = updateId;
    }
}

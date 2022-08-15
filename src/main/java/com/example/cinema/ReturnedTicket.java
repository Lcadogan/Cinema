package com.example.cinema;

public class ReturnedTicket {

    private final Ticket returnedTicket;

    public ReturnedTicket(Ticket returnedTicket) {
        this.returnedTicket = returnedTicket;
    }

    public Ticket getReturnedTicket() {
        return returnedTicket;
    }
}

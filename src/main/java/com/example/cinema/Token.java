package com.example.cinema;

import java.util.UUID;

public class Token {

    private final UUID token;
    private final Ticket ticket;

    public Token(Ticket ticket) {
        this.token = UUID.randomUUID();
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public UUID getToken() {
        return token;
    }
}

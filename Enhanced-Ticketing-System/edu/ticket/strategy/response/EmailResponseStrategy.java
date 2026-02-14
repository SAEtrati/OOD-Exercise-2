package edu.ticket.strategy.response;

import edu.ticket.model.Ticket;

public class EmailResponseStrategy implements ResponseStrategy {

    @Override
    public void send(Ticket ticket, String message) {
        System.out.println("Sending EMAIL to ticket #" + ticket.getId() + ": " + message);
    }
}

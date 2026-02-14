package edu.ticket.strategy.response;

import edu.ticket.model.Ticket;

public class SmsResponseStrategy implements ResponseStrategy {

    @Override
    public void send(Ticket ticket, String message) {
        System.out.println("Sending SMS for ticket #" + ticket.getId() + ": " + message);
    }
}

package edu.ticket.strategy.response;

import edu.ticket.model.Ticket;

public class PortalResponseStrategy implements ResponseStrategy {

    @Override
    public void send(Ticket ticket, String message) {
        System.out.println("Sending PORTAL notification for ticket #" + ticket.getId() + ": " + message);
    }
}

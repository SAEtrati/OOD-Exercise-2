package edu.ticket.strategy.response;

import edu.ticket.model.Ticket;

public interface ResponseStrategy {

    void send(Ticket ticket, String message);
}

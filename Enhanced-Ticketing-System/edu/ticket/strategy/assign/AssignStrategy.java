package edu.ticket.strategy.assign;

import edu.ticket.model.Ticket;

public interface AssignStrategy {

    String assign(Ticket ticket);
}
package edu.ticket.strategy.assign;

import edu.ticket.model.Ticket;
import edu.ticket.model.TicketType;

public class DefaultAssignStrategy implements AssignStrategy {

    @Override
    public String assign(Ticket ticket) {
        TicketType type = ticket.getType();
        switch (type) {
            case INCIDENT:
                return "Engineering";
            case REQUEST:
                return "Support";
            case QUESTION:
                return "General";
            default:
                return "Support";
        }
    }
}
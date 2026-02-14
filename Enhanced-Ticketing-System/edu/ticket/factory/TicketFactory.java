package edu.ticket.factory;

import edu.ticket.model.Channel;
import edu.ticket.model.Priority;
import edu.ticket.model.Ticket;
import edu.ticket.model.TicketType;

import java.util.Map;

public class TicketFactory {

    private static int counter = 0;

    public Ticket create(Map<String, String> data, Channel channel) {
        counter++;
        String title = data.getOrDefault("title", "Untitled");
        String description = data.getOrDefault("description", "");
        TicketType type = TicketType.valueOf(data.getOrDefault("type", "REQUEST"));
        Priority priority = Priority.valueOf(data.getOrDefault("priority", "MEDIUM"));

        Ticket ticket = new Ticket(counter, title, type, priority, channel);
        ticket.setDescription(description);
        return ticket;
    }
}
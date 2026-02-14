package edu.ticket.model;

import edu.ticket.state.NewState;
import edu.ticket.state.TicketState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {

    private final int id;
    private String title;
    private String description;
    private TicketType type;
    private Priority priority;
    private Channel channel;
    private TicketState state;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final List<String> comments;
    private final Map<String, String> metadata;

    public Ticket(int id, String title, TicketType type, Priority priority, Channel channel) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.priority = priority;
        this.channel = channel;
        this.state = new NewState();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.comments = new ArrayList<>();
        this.metadata = new HashMap<>();
        this.state.enter(this);
    }

    public void applyAction(String action) {
        TicketState nextState = state.next(action);
        state.exit(this);
        state = nextState;
        state.enter(this);
        updatedAt = LocalDateTime.now();
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public String getSummary() {
        return "Ticket #" + id + " [" + state.getName() + "] - " + title;
    }

    // --- Getters and Setters ---

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public TicketState getState() {
        return state;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<String> getComments() {
        return comments;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }
}

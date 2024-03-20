package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Event {

    //ATTRIBUTES LIST:
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private LocalDate eventDate;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private int maxNumberParticipants;


    //CONSTRUCTORS:
    public Event() {}
    public Event(String title, LocalDate eventDate, String description, EventType eventType, int maxNumberParticipants) {
       this.title = title;
       this.eventDate = eventDate;
       this.description = description;
       this.eventType = eventType;
       this.maxNumberParticipants = maxNumberParticipants;
    }

}

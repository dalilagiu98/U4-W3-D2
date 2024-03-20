package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Event;
import org.example.exceptions.NotFoundIdException;

public class EventDAO {

    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Event event) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(event);
            transaction.commit();
            System.out.println("Event " + event.getTitle() + " saved correctly!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event getById (long id) {
        Event event = em.find(Event.class, id);
        if(event == null) throw new NotFoundIdException(id);
        return event;
    }

    public void delete(long id) {
        Event found = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Event with id " + found.getId() + " was deleted!" );
    }
}

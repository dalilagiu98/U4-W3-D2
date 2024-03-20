package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventDAO;
import org.example.entities.Event;
import org.example.entities.EventType;

import java.time.LocalDate;

public class ManageEvents {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);

        Event sagra = new Event("Sagra della polpetta", LocalDate.now().plusWeeks(13), "sagra della polpetta di Norcia", EventType.PUBLIC, 130000);
        ed.save(sagra);

    }
}

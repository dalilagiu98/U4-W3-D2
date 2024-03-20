package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.EventDAO;
import org.example.entities.Event;
import org.example.entities.EventType;
import org.example.exceptions.NotFoundIdException;

import java.time.LocalDate;

public class ManageEvents {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);

        Event sagra = new Event("Sagra della polpetta", LocalDate.now().plusWeeks(13), "sagra della polpetta di Norcia", EventType.PUBLIC, 130000);
        Event sagra1 = new Event("Sagra della porchetta", LocalDate.now().plusWeeks(12), "sagra della porchetta romana", EventType.PRIVATE, 45);
        Event sagra2 = new Event("Sagra del polipo", LocalDate.now().plusWeeks(3), "sagra del polipo di Siracusa", EventType.PUBLIC, 5435643);

        ed.save(sagra1);
        ed.save(sagra);
        ed.save(sagra2);

        try {
            Event sagraToFind = ed.getById(1);
            System.out.println(sagraToFind);
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }

        try {
            ed.delete(1);
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        em.close();
        emf.close();
    }
}

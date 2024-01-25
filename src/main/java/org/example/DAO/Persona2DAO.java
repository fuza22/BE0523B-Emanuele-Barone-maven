package org.example.DAO;

import org.example.entities.Evento;
import org.example.entities.Persona2;

import jakarta.persistence.*;

public class Persona2DAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Persona2DAO() {

        emf = Persistence.createEntityManagerFactory("gestioneeventi");
        em = emf.createEntityManager();

    }

    public void save(Persona2 p){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(p);

        et.commit();

        em.refresh(p);

    }

    public Persona2 getById(int id){

        return em.find(Persona2.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        Persona2 p = getById(id);

        em.remove(p);

        et.commit();


    }

}

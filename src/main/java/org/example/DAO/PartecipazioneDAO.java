package org.example.DAO;

import org.example.entities.Partecipazione;
import org.example.entities.Persona2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PartecipazioneDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PartecipazioneDAO() {

        emf = Persistence.createEntityManagerFactory("gestioneeventi");
        em = emf.createEntityManager();

    }

    public void save(Partecipazione p){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(p);

        et.commit();

        em.refresh(p);

    }

    public Partecipazione getById(int id){

        return em.find(Partecipazione.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        Partecipazione p = getById(id);

        em.remove(p);

        et.commit();


    }

}

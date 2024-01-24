package org.example.DAO;

import org.example.entities.Location;
import org.example.entities.Persona2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LocationDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public LocationDAO() {

        emf = Persistence.createEntityManagerFactory("gestioneeventi");
        em = emf.createEntityManager();

    }

    public void save(Location l){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(l);

        et.commit();

        em.refresh(l);

    }

    public Location getById(int id){

        return em.find(Location.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        Location l = getById(id);

        em.remove(l);

        et.commit();


    }

}

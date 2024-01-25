package org.example.DAO;

import org.example.entities.Evento;
import jakarta.persistence.*;
import org.example.m1.w3.d4.entities.Concerto;
import org.example.m1.w3.d4.entities.PartitaDiCalcio;

import javax.management.Query;
import java.util.List;

@NamedQuery(name = "get_concerti_in_streaming", query = "select c from Concerto c where c.in_streaming = :in_streaming")
@NamedQuery(name = "get_concerti_per_genere", query = "select c from Concerto c where c.genere = :genere")
@NamedQuery(name = "get_partite_vinte_in_casa", query = "select p from PartitaDiCalcio p where p.squadraVincente = :squadraVincente")
@NamedQuery(name = "get_partite_vinte_in_trasferta", query = "select p from PartitaDiCalcio p where p.squadraVincente = :squadraVincente")
public class EventoDAO {


    private EntityManagerFactory emf;
    private EntityManager em;

    public EventoDAO() {

        emf = Persistence.createEntityManagerFactory("eventi");
        em = emf.createEntityManager();

    }


    public void save(Evento e){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);

    }

    public Evento getById(int id){

        return em.find(Evento.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        Evento e = getById(id);

        em.remove(e);

        et.commit();


    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createNamedQuery("get_concerti_in_streaming", Concerto.class);
        query.setParameter("in_streaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(String genere) {
        TypedQuery<Concerto> query = em.createNamedQuery("get_concerti_per_genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }


    public List<PartitaDiCalcio> getPartiteVinteInCasa(){

        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio", PartitaDiCalcio.class);

        return query.getResultList();

    }
}

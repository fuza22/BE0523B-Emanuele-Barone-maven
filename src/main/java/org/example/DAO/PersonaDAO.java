package org.example.DAO;


import org.example.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonaDAO {

        private EntityManagerFactory emf;
        private EntityManager em;

        public PersonaDAO(){

            emf = Persistence.createEntityManagerFactory("epicodeJpa");
            em = emf.createEntityManager();

        }

        public void inserisciPersona(Persona p){

            EntityTransaction et = em.getTransaction(); // quando si deve fare un inserimento si deve creare un elemento di entity transaction
            et.begin();

            em.persist(p); // metodo per creare nel persistence context un'entita di tipo persona

            et.commit(); // finisce la transazione

            em.refresh(p); // si fa un refresh dell'entity manager

        }


        public Persona getById(int id){

            return em.find(Persona.class, id); // passeremo l'id e il tipo di dato (di tipo class) che vogliamo mappare per trovarlo


        }


        public void cancellaPersona(int id){

            EntityTransaction et = em.getTransaction(); // creiamo la transazione

            et.begin(); // iniziamo la transazione

            Persona p = getById(id); // vado a riutilizzare il metodo get per restituire l'oggetto di tipo persona che ha quell'id
            em.remove(p); // metodo per rimuovere l'elemento

            et.commit(); // terminiamo la transazione

        }

}

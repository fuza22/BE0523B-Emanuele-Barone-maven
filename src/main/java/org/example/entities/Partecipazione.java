package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn
    private Persona2 persona2;

    @ManyToOne
    @JoinColumn
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(){}

    public Partecipazione(Persona2 persona2, Evento evento, Stato stato) {
        this.persona2 = persona2;
        this.evento = evento;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona2 getPersona2() {
        return persona2;
    }

    public void setPersona2(Persona2 persona2) {
        this.persona2 = persona2;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona2=" + persona2 +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}

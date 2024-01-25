package org.example.m1.w3.d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.entities.Evento;
import org.example.entities.Persona2;

import java.util.Set;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {

    private Set<Persona2> atleti;

    private Persona2 vincitore;


    public GaraDiAtletica(Set<Persona2> atleti, Persona2 vincitore) {
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica(){}

    public Set<Persona2> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona2> atleti) {
        this.atleti = atleti;
    }

    public Persona2 getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona2 vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return super.toString() +
                "atleti=" + atleti +
                ", vincitore=" + vincitore;
    }
}

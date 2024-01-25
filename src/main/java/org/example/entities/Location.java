package org.example.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    public Location(){}

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }



    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}

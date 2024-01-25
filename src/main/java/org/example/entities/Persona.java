package org.example.entities;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persona") // diamo un nome alla tabella creata
public class Persona {
    @Id // servirà a far capire che questa è una chiave primaria nella tabella
    @GeneratedValue(strategy = GenerationType.AUTO) // verrà autogestita dal dbms
    private int id;


    private String nome;
    private String cognome;

    @Column(name = "data_nascita", nullable = false) // stabiliamo le varie caratteristiche della colonna
    private LocalDate dataNascita;

    @Enumerated(EnumType.STRING) // il corrispondente tipo nella tabella sarà una stringa
    private Mestiere mestiere;

    public Persona(){}

    public Persona(int id, String nome, String cognome, LocalDate dataNascita, Mestiere mestiere) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.mestiere = mestiere;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Mestiere getMestiere() {
        return mestiere;
    }

    public void setMestiere(Mestiere mestiere) {
        this.mestiere = mestiere;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", mestiere=" + mestiere +
                '}';
    }
}

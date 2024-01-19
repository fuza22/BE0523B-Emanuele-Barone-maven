package org.example.m1.d5;

import java.util.Random;

public class Riviste extends DatiCartacei {

    private Periodicita periodicita;


    public Riviste(long codiceISBN, String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }

    public Riviste(String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public static Riviste creaRivista(String titolo, int annoPubblicazione, int numPagine, Periodicita periodicita){

        Random random = new Random();
        Long codiceISBN = random.nextLong();

        Riviste nuovaRivista = new Riviste(codiceISBN, titolo, annoPubblicazione, numPagine, periodicita);
        System.out.println("Rivista " + "'"+ titolo + "'" + " creata.");

        return nuovaRivista;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "periodicita=" + periodicita +
                '}';
    }
}

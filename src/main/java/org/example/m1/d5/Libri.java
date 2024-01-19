package org.example.m1.d5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Libri extends DatiCartacei {

    private String autore;
    private List<Genere> genere;

    public Libri(long codiceISBN, String titolo, int annoPubblicazione, int numPagine, String autore, Genere ...genere) {
        super(codiceISBN, titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genere = Arrays.asList(genere);
    }

    public Libri(String titolo, int annoPubblicazione, int numPagine, String autore, List<Genere> genere) {
        super(titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public List<Genere> getGenere() {
        return genere;
    }

    public void setGenere(List<Genere> genere) {
        this.genere = genere;
    }

    public static Libri creaLibro(String titolo, int annoPubblicazione, int numPagine, String autore, Genere ...genere){

        Random random = new Random();
        Long codiceISBN = random.nextLong();

        Libri nuovoLibro = new Libri(codiceISBN, titolo, annoPubblicazione, numPagine, autore, genere);
        System.out.println("Libro " + "'"+ titolo + "'" + " creato.");

        return nuovoLibro;
    }

    @Override
    public String toString() {
        return super.toString() + "Libri{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }


}

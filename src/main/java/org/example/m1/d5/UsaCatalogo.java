package org.example.m1.d5;

import java.io.IOException;

public class UsaCatalogo extends Catalogo {

    public static void main(String[] args) throws IOException {

        Libri l1 = Libri.creaLibro("Harry Potter ed i suoi malefatti",2023,1290, "J.K. Rowling", Genere.HORROR);
        Libri l2 = Libri.creaLibro("Pizza e fichi",2021,990, "Pippo", Genere.COMMEDIA);
        System.out.println(l1);
        System.out.println(l2);


        Riviste r1 = Riviste.creaRivista("Chi", 2024, 60, Periodicita.SETTIMANALE);
        System.out.println(r1);

        Catalogo lista = new Catalogo();


        lista.aggiungiElemento(l1);

        System.out.println(lista);

        lista.aggiungiElemento(l2);

        System.out.println(lista.toString());

        lista.aggiungiElemento(r1);

        System.out.println(lista.toString());


        System.out.println(lista);

        System.out.println(lista.ricercaISBN(1));

        System.out.println(lista.ricercaAnno(2021));

        System.out.println(lista.ricercaAutore("J.K. Rowling"));

        lista.salva(catalogo);

    }
}

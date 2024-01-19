package org.example.m1.d5;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Catalogo {

    public static List<DatiCartacei> catalogo;

    public Catalogo() {

        this.catalogo = new ArrayList<>();

    }


    public void aggiungiElemento(DatiCartacei e){

        catalogo.add(e);
        System.out.println("Elemento aggiunto al catalogo.");

    }

    public void rimuoviISBN(long isbn){

        catalogo.removeIf(e -> e.getCodiceISBN() == isbn );
        System.out.println("L'elemento con codice " + isbn + " è stato eliminato.");

    }

    public DatiCartacei ricercaISBN(long isbn){

       Optional<DatiCartacei> dato = catalogo.stream().filter(e -> e.getCodiceISBN() == isbn).findFirst();
        System.out.println("Hai cercato il libro con il codice: " + isbn);
        return dato.orElse(null);
    }

    public List<DatiCartacei> ricercaAnno(int a){

        System.out.println("Hai cercato i libri scritti nel " + a );

        return catalogo.stream().filter(g -> g.getAnnoPubblicazione() == a)
                .collect(Collectors.toList());

    }

    public List<Libri> ricercaAutore(String a){

        System.out.println("Hai cercato i libri scritti dall'autore " + a );

        return catalogo.stream()
                .filter(e -> e instanceof Libri)
                .map(Libri.class::cast)
                .filter(l -> l.getAutore() == a)
                .collect(Collectors.toList());

    }


    public void salva(List<DatiCartacei> p) throws IOException {
        File out = new File("output/lista.txt");

        String stringaCatalogo = p.stream()
                .map(c -> {
                    if (c instanceof Libri) {
                        Libri libro = (Libri) c;
                        return libro.getTitolo() +
                                "@" + libro.getCodiceISBN() +
                                "@" + libro.getAnnoPubblicazione() +
                                "@" + libro.getNumPagine() +
                                "@" + libro.getAutore() +
                                "@" + libro.getGenere().stream().map(Enum::name).collect(Collectors.joining(","));
                    } else if (c instanceof Riviste) {
                        Riviste rivista = (Riviste) c;
                        return rivista.getTitolo() +
                                "@" + rivista.getCodiceISBN() +
                                "@" + rivista.getAnnoPubblicazione() +
                                "@" + rivista.getNumPagine() +
                                "@" + rivista.getPeriodicita().name();
                    } else {
                        return c.getTitolo() +
                                "@" + c.getCodiceISBN() +
                                "@" + c.getAnnoPubblicazione() +
                                "@" + c.getNumPagine();
                    }
                })
                .collect(Collectors.joining("#"));

        FileUtils.writeStringToFile(out, stringaCatalogo, Charset.defaultCharset());
    }



    @Override
    public String toString() {
        return "{" +
                "Catalogo: " + catalogo +
                '}';
    }
}

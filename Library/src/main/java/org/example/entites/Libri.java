package org.example.entites;

import java.util.Random;

public class Libri {
    Long id;
    String titolo;
    int annoPublicazione;
    int numeroPagine;
    String autore;
    String genere;

    public Libri(String titolo,int annoPublicazione, int numeroPagine, String autore, String genere) {
        Random rndm = new Random();
        this.id = rndm.nextLong();
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.genere = genere;
    }

    public Long getId() {
        return id;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public String getTitolo() {
        return titolo;
    }


}

package entites;

import java.util.Random;

public class Reviste {
    Long id;
    String titolo;
    int annoPublicazione;
    int numeroPagine;
    String periodicita;
    public Reviste(String titolo,int annoPublicazione, int numeroPagine, String periodicita) {
        Random rndm = new Random();
        this.id = rndm.nextLong();
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
        this.periodicita = periodicita;
    }

    public Long getId() {
        return id;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }
    public String getTitolo() {
        return titolo;
    }
}

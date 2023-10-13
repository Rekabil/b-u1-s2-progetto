package org.example;

import org.apache.commons.io.FileUtils;
import org.example.entites.Libri;
import org.example.entites.Reviste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    static List<Libri> catalogoLibri = new ArrayList<>();
    static List<Reviste> catalogoReviste= new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Libri book1 = new Libri("Lord of the Rings", 1952, 599, "J. R. R. Tolkien", "Fantasy");
        Libri book2 = new Libri("The Hobbit", 1927, 453, "J. R. R. Tolkien", "Fantasy");
        Libri book3 = new Libri("Horus Rising", 2006, 520, "Dan Abnett", "Sci-fi");
        Libri book4 = new Libri("False Gods", 2006, 680, "Graham McNeill", "Sci-fi");
        Libri book5 = new Libri("A Game of Thrones ", 1996, 694, "George R. R. Martin", "Fantasy");


        Reviste rev1 = new Reviste("GamingMonth" , 2013, 156 , "MENSILE");
        Reviste rev2 = new Reviste("VHero" , 2021, 142 , "MENSILE");
        Reviste rev3 = new Reviste("FifaNews" , 2002, 56, "SETTIMANALE");
        Reviste rev4 = new Reviste("UpComing" , 2014, 350 , "SEMESTRALE");
        Reviste rev5 = new Reviste("Vouge" , 2005, 56 , "SETTIMANALE");



        catalogoLibri.add(book1);
        catalogoLibri.add(book2);
        catalogoLibri.add(book3);
        catalogoLibri.add(book4);
        catalogoLibri.add(book5);

        catalogoReviste.add(rev1);
        catalogoReviste.add(rev2);
        catalogoReviste.add(rev3);
        catalogoReviste.add(rev4);
        catalogoReviste.add(rev5);


        start();


    }
    public static void start() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserici il numero della optione desiderata.");
        System.out.println("1. Aggiungi un nuovo Libro o Revista");
        System.out.println("2. Monstra tutti i Catalogi");
        System.out.println("3. Rimuovere un Elemento");
        System.out.println("4. Ricerca uno libro o revista specifico");
        System.out.println("5. Salva i catalogi nel disco locale");
        System.out.println("6. Prendi i dati dal disco locale");
        int num = Integer.parseInt(input.nextLine());

        switch (num) {
            case 1: {
                aggiungi();
            }
            case 2: {
                stampaLibreria();
            }
            case 3: {
                rimuovere();
            }
            case 4: {
                search();
            }
            case 5: {
                saveToDisk();
            }
            case 6:{
                loadFromDisk();
            }
        }

    }


    public static void aggiungi() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserici 1. per aggiungere un Libro o 2. per Aggiungere una Revista");
        int num = Integer.parseInt(input.nextLine());

        if (num == 1 ) {
            System.out.println("Inserici il Titolo");
            String titolo = input.nextLine();

            System.out.println("Inserici il Anno di Publicazione");

            int anno = Integer.parseInt(input.nextLine());
            System.out.println("Inserici il Numero di Pagine");
            int numPag = Integer.parseInt(input.nextLine());
            System.out.println("Inserici il Autore");
            String autore = input.nextLine();
            System.out.println("Inserici il Genere");
            String genere = input.nextLine();
            Libri libri = new Libri(titolo , anno , numPag , autore, genere);
            catalogoLibri.add(libri);
            System.out.println("Libro aggiunto con Successo");

            start();


        } else if (num == 2) {
            System.out.println("Inserici il Titolo");
            String titolo = input.nextLine();
            System.out.println("Inserici il Anno di Publicazione");
            int anno = Integer.parseInt(input.nextLine());
            System.out.println("Inserici il Numero di Pagine");
            int numPag = Integer.parseInt(input.nextLine());
            System.out.println("Inserici la Periodicita:");
            System.out.println("1. SETTIMANALE");
            System.out.println("2. MENSILE");
            System.out.println("3. SEMESTRALE");
            int periodicitaCase = Integer.parseInt(input.nextLine());
            String periodicita = "";
            switch (periodicitaCase) {
                case 1: periodicita = "SETTIMANALE";
                case 2: periodicita = "MENSILE";
                case 3: periodicita = "SEMESTRALE";
            }

            Reviste reviste = new Reviste(titolo , anno , numPag , periodicita );
            catalogoReviste.add(reviste);
            System.out.println("Revista aggiunto con Successo");

            start();
        } else {
            System.out.println("Input Error. Redirecting to Start");
            start();
        }
    }

    public static void stampaLibreria() throws IOException {
        System.out.println("Catalogo Libri");
        catalogoLibri.forEach(libri -> System.out.println("Titolo: " + libri.getTitolo() + " Autore: " + libri.getAutore()+" Anno Publicazione: "+ libri.getAnnoPublicazione() + " Genere: " +libri.getGenere() + " ISBN: " +libri.getId()    ));
        System.out.println("Catalogo Reviste");
        catalogoReviste.forEach(reviste -> System.out.println("Titolo: " + reviste.getTitolo()+" Anno Publicazione: "+ reviste.getAnnoPublicazione() + " ISBN: " +reviste.getId()));
        start();
    }

    public static void rimuovere() throws IOException {
        System.out.println("Vuoi Rimuovere un Libro o Revista");
        System.out.println("Inserisci 1 per Libro e qualsiasi altro numero per Revista");
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        if (num == 1) {
            System.out.println("Devi inserire il ISBN del Libro");
            Long isbn = Long.valueOf(input.nextLine());
            catalogoLibri.removeIf(libri -> libri.getId().equals(isbn));
            System.out.println("Libro rimosso");
        } else {
            System.out.println("Devi inserire il ISBN della Revista");
            Long isbn = Long.valueOf(input.nextLine());
            catalogoReviste.removeIf(reviste -> reviste.getId().equals(isbn));
            System.out.println("Revista rimosso");
        }
        start();
    }

    public static void search() {
        System.out.println("Premi 1 se vuoi Ricercare un Libro o qualsiasi altra cosa per Revista");
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        if (num == 1) {
            searchLibro();
        } else searchRevista();
    }
    public static void searchLibro() {
        System.out.println("Che parametro vuoi usare per la ricerca?");
        System.out.println("1. ISBN");
        System.out.println("2. Anno Uscita");
        System.out.println("3. Autore");
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        switch (num) {
            case 1: {
                System.out.println("Inserici il ISBN");
                Long isbn = Long.valueOf(input.nextLine());
                List<Libri> risultato = catalogoLibri.stream().filter(libri -> libri.getId().equals(isbn)).toList();
                System.out.println("Risultato:");
                risultato.forEach(libri-> System.out.println("Titolo: " + libri.getTitolo() + " Autore: " + libri.getAutore()+" Anno Publicazione: "+ libri.getAnnoPublicazione() + " Genere: " +libri.getGenere() + " ISBN: " +libri.getId()    ));
                break;
            }
            case 2: {
                System.out.println("Inserici il Anno di usita");
                int anno = Integer.parseInt(input.nextLine());
                List<Libri> risultato = catalogoLibri.stream().filter(libri -> libri.getAnnoPublicazione() == anno).toList();
                System.out.println("Risultato:");
                risultato.forEach(libri-> System.out.println("Titolo: " + libri.getTitolo() + " Autore: " + libri.getAutore()+" Anno Publicazione: "+ libri.getAnnoPublicazione() + " Genere: " +libri.getGenere() + " ISBN: " +libri.getId()    ));
                break;
            }
            case 3: {
                System.out.println("Inserici il Autore");
                String autore = input.nextLine();
                List<Libri> risultato = catalogoLibri.stream().filter(libri -> libri.getAutore().equals(autore)).toList();
                System.out.println("Risultato:");
                risultato.forEach(libri-> System.out.println("Titolo: " + libri.getTitolo() + " Autore: " + libri.getAutore()+" Anno Publicazione: "+ libri.getAnnoPublicazione() + " Genere: " +libri.getGenere() + " ISBN: " +libri.getId()    ));

            }
        }

    }
    public static void searchRevista() {
        System.out.println("Che parametro vuoi usare per la ricerca?");
        System.out.println("1. ISBN");
        System.out.println("2. Anno Uscita");
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        switch (num) {
            case 1: {
                System.out.println("Inserici il ISBN");
                Long isbn = Long.valueOf(input.nextLine());
                List<Reviste> risultato = catalogoReviste.stream().filter(libri -> libri.getId().equals(isbn)).toList();
                System.out.println("Risultato:");
                risultato.forEach(libri-> System.out.println("Titolo: " + libri.getTitolo() +" Anno Publicazione: "+ libri.getAnnoPublicazione() + " ISBN: " +libri.getId()    ));
                break;
            }
            case 2: {
                System.out.println("Inserici il Anno di usita");
                int anno = Integer.parseInt(input.nextLine());
                List<Reviste> risultato = catalogoReviste.stream().filter(reviste -> reviste.getAnnoPublicazione() == anno).toList();
                System.out.println("Risultato:");
                risultato.forEach(libri-> System.out.println("Titolo: " + libri.getTitolo() + " Anno Publicazione: "+ libri.getAnnoPublicazione()  + " ISBN: " +libri.getId()    ));
                break;
            }
        }
    }

    public static void saveToDisk() throws IOException {
        try {
            String catalogolibri = "";
            String catalogoreviste = "";


            for (Libri libri : catalogoLibri) {
                catalogolibri += libri.getTitolo()+ "@" +libri.getAnnoPublicazione()+"@"+ libri.getNumeroPagine()+ "@" + libri.getAutore() + "@" + libri.getGenere() + "#";
            }

            for (Reviste reviste : catalogoReviste) {
                catalogoreviste += reviste.getTitolo() + "@" + reviste.getAnnoPublicazione()+ "@"+ reviste.getNumeroPagine() +"@" + reviste.getPeriodicita()+ "#";
            }
            File file = new File("catalogLibri.txt");
            File reviste = new File("catalogoRev.txt");
            FileUtils.writeStringToFile(file, catalogolibri , "UTF-8");
            FileUtils.writeStringToFile(reviste, catalogoreviste , "UTF-8");
            System.out.println("Salvato con Sucesso");

        } catch (IOException e) {
            System.out.println("Errore");
            e.printStackTrace();
        }
    }

    public static void loadFromDisk() throws FileNotFoundException {
        try {
            File libricatalog = new File("catalogLibri.txt");
            File revistecatalog = new File("catalogoRev.txt");

            System.out.println("Catalogo Libri");
            String dataLibri = FileUtils.readFileToString(libricatalog,"UTF-8");
            List<String> libriSplit = Arrays.asList(dataLibri.split("#"));
            List<Libri> listaLibri = libriSplit.stream().map(stringa -> {
                    String[] libriInfo = stringa.split("@");
                    return new Libri(libriInfo[0], Integer.parseInt(libriInfo[1])  ,Integer.parseInt(libriInfo[2]) ,libriInfo[3],libriInfo[4]);
            }).toList();
            listaLibri.forEach(libri ->  System.out.println(libri.getTitolo()+ " " +libri.getAnnoPublicazione()+" "+ libri.getNumeroPagine()+ " " + libri.getAutore() + " " + libri.getGenere() + " "));

System.out.println("Catalogo Reviste");
                String dataReviste = FileUtils.readFileToString(revistecatalog,"UTF-8");
                List<String> revisteSplit = Arrays.asList(dataReviste.split("#"));
                List<Reviste> listaReviste = revisteSplit.stream().map(stringa -> {
                    String[] revisteInfo = stringa.split("@");
                    return new Reviste(revisteInfo[0], Integer.parseInt(revisteInfo[1])  ,Integer.parseInt(revisteInfo[2]) ,revisteInfo[3]);
                }).toList();
            listaReviste.forEach(libri ->  System.out.println(libri.getTitolo()+ " " +libri.getAnnoPublicazione()+" "+ libri.getNumeroPagine()+ " " + libri.getPeriodicita()));

        } catch (FileNotFoundException e) {
            System.out.println("C'e un Errore");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

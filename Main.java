import entites.Libri;
import entites.Reviste;

public class Main {
    public static void main(String[] args) {
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

    }
}

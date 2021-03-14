import java.io.IOException;
import java.util.Scanner;

/*
                                    Projekt na praktyki

            Project jest zrobiony jako coś podobnego do "Systemu banku".
    Może mieć nieskończenie wiele użytkowników i dla każdego jest tworzony swój folder.

    Funkcje:
    - stan konta
    - wpłata i wypłata
    - doładowanie telefonu
    - kupienie samochodu
    - wyświetla i zmienia informacje o użytkowniku
    - zmiana hasła
 */

public class Main {

    //Działa jako pętla
    static int status = 0;

    public static void doit() throws IOException {
        if (status != 0){
            new functions();
            functions.FunkcjeList();
        }
    }

    //Wylogowanie
    public static void logout(){
        System.out.println("Wylogowano z konta");
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Program uruchomiono");

        new login();
        int l = 0;
        int i;
        do {
            Scanner skaner = new Scanner(System.in);
            login.loginList();
            try {
                l = skaner.nextInt();
                i = 1;
            }
            catch (Exception exception){
                System.out.println("Podano zły symbol, spróbój jeszcze raz");
                i = 0;
            }
        }
        while (i != 1);

        login.Autoryzaja(l);

        doit();

    }

}

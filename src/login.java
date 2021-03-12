import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class login {

    //Część kodu, która odpowiada za logowanie

    public static boolean status;
    public static boolean Log;
    public static String nazwa;

    public static void loginList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1. Zaloguj");
        list.add("2. Rejestracja");
        System.out.println("Podaj numer");
        System.out.println(list);
    }

    public static void Autoryzaja(int l) throws IOException {

        Scanner skaner = new Scanner(System.in);
        String nazwa, haslo;

        switch (l){
            case 1:
                log();
                break;
            case 2:
                System.out.print("Wymyśł login: ");
                nazwa = skaner.next();
                System.out.print("Wymyśł hasło: ");
                haslo = skaner.next();
                files.createFiles(nazwa,haslo);
                break;
            default:
                System.out.println("Nie wybrano dobrej opcji");
                break;
        }
    }

    public static void log() throws IOException {

            Scanner skaner = new Scanner(System.in);

            status = false;

            System.out.print("Podaj login: ");
            nazwa = skaner.next();

            System.out.print("Podaj haslo: ");
            String haslo = skaner.next();

            files.checkLogin(nazwa);

            if (status) {
                files.checkHaslo(nazwa,haslo);
            }

            if(Log){
                functions.FunkcjeList();
            }
            else {
                System.out.println("Nie zalogowano");
            }

    }

}

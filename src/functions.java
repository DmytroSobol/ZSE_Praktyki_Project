import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class functions {

    //Kod odpowiada za funkcje

    public static void FunkcjeList() throws IOException {

        new userinfo();
        new settings();

        System.out.println("\n\n Lista dostępnych funkcji:");
        String tab[] = new String[7];
        tab[0] = "1. Stan konta";
        tab[1] = "2. Wpłata na konto";
        tab[2] = "3. Wypłata z konta";
        tab[3] = "4. Doładowanie telefonu";
        tab[4] = "5. Ustawienia";
        tab[5] = "6. Zmiana hasła";
        tab[6] = "7. Wyloguj";

        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }

        Scanner skaner = new Scanner(System.in);
        int i = skaner.nextInt();

        switch (i){
            case 1:
                System.out.println("Stan konta: " + userinfo.getAmount(login.nazwa) + "zł");
                Main.status = 1;
                break;
            case 2:
                doladowanieKonta();
                break;
            case 3:
                wyplataKonta();
                break;
            case 4:
                doladowanie();
                break;
            case 5:
                settings.settings(login.nazwa);
                break;
            case 6:
                userinfo.setPass(login.nazwa);
                break;
            case 7:
                Main.status = 0;
                Main.logout();
                break;
            default:
                System.out.println("Nie wybrano dobrej opcji");
        }
    }

    //Doładowanie konta użytkownika
    private static void doladowanieKonta() throws IOException {
        System.out.println("Wpisz kwotę doładowania: ");
        Scanner skaner = new Scanner(System.in);
        int suma = skaner.nextInt();
        int kwota = userinfo.getAmount(login.nazwa) + suma;
        userinfo.setAmount(kwota,login.nazwa);
        System.out.println("Stan konta: " + userinfo.getAmount(login.nazwa) + "zł");

        Main.status = 1;
    }

    //Wypłata z konta użytkownika
    private static void wyplataKonta() throws IOException {

        ArrayList<String> kwoty = new ArrayList<>();
        kwoty.add("20zł");
        kwoty.add("50zł");
        kwoty.add("100zł");
        kwoty.add("200zł");
        kwoty.add("500zł");
        kwoty.add("Swoja kwota (podzielnia przez 50)");

        System.out.println("Stan konta: " + userinfo.getAmount(login.nazwa));
        System.out.println("Ile chcesz wypłacić?");
        System.out.println("Dostępne kwoty: " + kwoty);
        Scanner skaner = new Scanner(System.in);
        int suma = skaner.nextInt();

        if (suma == 20 || suma == 50 || suma == 100 || suma == 200 || suma == 500 || suma%50 == 0){
            if (userinfo.getAmount(login.nazwa) > 0){
                int kwota = userinfo.getAmount(login.nazwa) - suma;
                userinfo.setAmount(kwota,login.nazwa);
                System.out.println("Wypłacono: " + suma + "zł");
                System.out.println("Stan konta: " + userinfo.getAmount(login.nazwa) + "zł");
            }
            else {
                System.out.println("Nie wystarczająco środków na koncie");
            }
        }
        else {
            System.out.println("Podano złą kwote");
        }

        Main.status = 1;
        Main.doit();
    }

    //Doładowanie telefonu użytkownika
    public static void doladowanie() throws IOException {
        System.out.println("Wpisz numer telefonu (9 liczb)");
        Scanner skaner = new Scanner(System.in);
        int telefon = 0;
        try {
            Scanner skan = new Scanner(System.in);
            telefon = skan.nextInt();
        }
        catch (Exception exception){
        }

        if((int)(Math.log10(telefon)+1) == 9){
            System.out.println("Stan konta: " + userinfo.getAmount(login.nazwa));
            System.out.print("Wpisz kwotę doładowania: ");
            int suma = skaner.nextInt();
            if (suma < userinfo.getAmount(login.nazwa)){
                int kwota = userinfo.getAmount(login.nazwa) - suma;
                System.out.println("Telefon nr. " + telefon + " zostanie doładowany w ciągu kilku minut");
                userinfo.setAmount(kwota,login.nazwa);
            }
            else{
                System.out.println("Nie wystarczająco środków na koncie");
            }
        }
        else {
            System.out.println("Podano zły numer");
        }

        Main.status = 1;
        Main.doit();
    }
}

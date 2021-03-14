import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class cars {

    static int tab[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    static ArrayList<String> samochody = new ArrayList<>();


    //Wyświetla listę samochodów
    public static void carList() throws IOException {
        String who;
        System.out.println("Jesteś właściecielem? (Tak czy nie)");
        Scanner skane = new Scanner(System.in);
        who = skane.next();
        if (who.equals("t") || who.equals("Tak") || who.equals("tak") || who.equals("TAK")){
            carListAdmin();
        }
        else {
            carListCustomer();
        }

        Main.status = 1;
    }

    //Wyświetla samochód użytkownika i sprzedaje
    public static void carListCustomer() throws IOException {

        System.out.print("Twój samochód: ");
        userinfo.getCar();

        System.out.println("Lista samochodów:");
        int i;
        for(i = 0; i< samochody.size(); i++) {
            System.out.println("[" + i + "] " + samochody.get(i) + " cena: " + tab[i] + "zł");
        }
        System.out.print("Wpisz ID samochodu, który chcesz kupić: ");

        try {
            Scanner skanef = new Scanner(System.in);
            int indeks = skanef.nextInt();
            String car = samochody.get(indeks);
            if(userinfo.getAmount(login.nazwa) >= tab[i]){
                int kwota = userinfo.getAmount(login.nazwa) - tab[i];
                userinfo.setCar(car);
                samochody.remove(indeks);
                userinfo.setAmount(kwota,login.nazwa);
            }
            else {
                System.out.println("Nie wystarczająco środków na koncie");
            }
        }
        catch (Exception exception){
            System.out.println("Podano nie liczbe");
        }
    }

    //Panel sterowania salonem
    public static void carListAdmin() throws IOException {
        Random random = new Random();
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Dodaj auto");
        lista.add("Dodaj auto po indeksie");
        lista.add("Podmień auto po indeksie");
        lista.add("Usuń auto po indeksie");
        lista.add("Usuń auto po nazwie");
        lista.add("Sprawdzanie czy podane auto już jest");
        lista.add("Posortowanie aut");
        lista.add("Wyciągnięcie auta po indeksie i wyświetlenie nazwy");
        lista.add("Wyświetlenie liczby aut");
        lista.add("Usunięcie wszystkich aut");
        lista.add("Wyświetl wszystkie auta");
        lista.add("Wyjście");

        int i;
        for(i = 0; i< lista.size(); i++) {
            System.out.println("[" + i + "] " + lista.get(i));
        }

        try {
            Scanner skaner = new Scanner(System.in);
            i = skaner.nextInt();
        }
        catch (Exception exception){
            System.out.println("Podano nie liczbę");
        }

        String auto;
        int indeks;

        switch (i){
            case 0:
                Scanner skaner = new Scanner(System.in);
                System.out.println("Podaj nazwę samochodu");
                auto = skaner.next();
                tab[samochody.size()] = random.nextInt(5000);
                samochody.add(auto);
                System.out.println("Samochód dodano");

                Main.status = 1;
                break;
            case 1:
                Scanner skaner2 = new Scanner(System.in);
                System.out.println("Podaj nazwę samochodu");
                auto = skaner2.next();
                System.out.println("Podaj indeks samochodu");
                indeks = skaner2.nextInt();
                tab[indeks] = random.nextInt(5000);
                samochody.add(indeks,auto);
                System.out.println("Samochód po indeksie dodano");

                Main.status = 1;
                break;
            case 2:
                System.out.println("Lista samochodów: ");
                System.out.println(samochody);
                Scanner skaner3 = new Scanner(System.in);
                System.out.println("Podaj indeks samochodu");
                indeks = skaner3.nextInt();
                System.out.println("Podaj nazwę nowego samochodu");
                auto = skaner3.next();
                samochody.set(indeks,auto);
                System.out.println("Samochód po indeksie podmieniono");
                System.out.println("Nowa lista samochodów: ");
                System.out.println(samochody);

                Main.status = 1;
                break;
            case 3:
                System.out.println("Lista samochodów: ");
                System.out.println(samochody);
                Scanner skaner4 = new Scanner(System.in);
                System.out.println("Podaj indeks samochodu");
                indeks = skaner4.nextInt();
                tab[indeks] = 0;
                samochody.remove(indeks);
                System.out.println("Samochód po indeksie usunięto");

                Main.status = 1;
                break;
            case 4:
                Scanner skaner5 = new Scanner(System.in);
                System.out.println("Podaj nazwę samochodu");
                auto = skaner5.next();
                indeks = samochody.indexOf(auto);
                tab[indeks] = 0;
                samochody.remove(auto);
                System.out.println("Samochód po indeksie usunięto");

                Main.status = 1;
                break;
            case 5:
                Scanner skaner6 = new Scanner(System.in);
                System.out.println("Podaj nazwę samochodu");
                auto = skaner6.next();

                if (samochody.contains(auto)){
                    System.out.println("Lista samochodów już zawiera " + auto);
                }else {
                    System.out.println("Lista samochodów nie zawiera " + auto);
                }

                Main.status = 1;
                break;
            case 6:
                System.out.println("Przed sortowaniem:");
                System.out.println(samochody);
                Collections.sort(samochody);
                System.out.println("Posortowano samochody");
                System.out.println(samochody);

                Main.status = 1;
                break;
            case 7:
                Scanner skaner7 = new Scanner(System.in);
                System.out.println("Podaj indeks samochodu");
                indeks = skaner7.nextInt();
                System.out.println(samochody.get(indeks));

                Main.status = 1;
                break;
            case 8:
                System.out.println("Liczba samochodów: " + samochody.size());

                Main.status = 1;
                break;
            case 9:
                System.out.println("Czy napewno chcesz usunąć wszystkie samochody? (Tak czy nie)");
                Scanner skaner8 = new Scanner(System.in);
                String tn = skaner8.next();
                if(tn == "t" || tn == "T" || tn == "tak" || tn == "TAK" || tn == "Tak"){
                    samochody.clear();
                    System.out.println("Usunięto wszystkie samochody");
                }

                Main.status = 1;
                break;
            case 10:
                System.out.println(samochody);

                Main.status = 1;
                break;
            case 11:
                System.out.println("Wyjście");

                Main.status = 1;
                break;
            default:
                System.out.println("Podaną zły numer");

                Main.status = 1;
                break;
        }
        Main.doit();
    }
}

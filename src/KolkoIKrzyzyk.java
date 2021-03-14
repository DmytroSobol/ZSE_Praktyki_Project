import java.io.IOException;
import java.util.*;

public class KolkoIKrzyzyk {

    static ArrayList<Integer> pozycjeGracza = new ArrayList<Integer>();
    static ArrayList<Integer> pozycjeKomputera = new ArrayList<Integer>();

    static boolean end = false;
    static boolean game = true;

    public static void main() throws IOException {

        char [] []  planszaGry = {   {'1','|', '2', '|','3' },
                                     {'-','+', '-', '+','-' },
                                     {'4','|', '5', '|','6' },
                                     {'-','+', '-', '+','-' },
                                     {'7','|', '8', '|','9' }};

        wypiszPlanszaGry(planszaGry);

        while(game) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Wypisz gdzie chcesz ustawić X (1-9): ");
            int pozycjaGracz = scanner.nextInt();

            while(pozycjeGracza.contains(pozycjaGracz) || pozycjeKomputera.contains(pozycjaGracz)) {
                System.out.println("Tam Już jest zajęte!!!");
                System.out.println("Wypisz gdzie chcesz ustawić X (1-9): ");
                pozycjaGracz = scanner.nextInt();
            }
            ustawPionek(planszaGry, pozycjaGracz, "Gracz");

            String wynik = sprawdzWygrana();
            System.out.println(wynik);

            Random random = new Random();
            int komputerPozycja = random.nextInt(9) + 1;

            while(pozycjeGracza.contains(komputerPozycja) || pozycjeKomputera.contains(komputerPozycja)) {
                komputerPozycja = random.nextInt(9) + 1;
            }
            ustawPionek(planszaGry, komputerPozycja, "Komputer");

            wynik = sprawdzWygrana();
            System.out.println(wynik);

            wypiszPlanszaGry(planszaGry);

            if (!end){
                if(wynik.length() > 0) {
                    System.out.println("\n\nGRA ZAKONCZONA");
                    wypiszPlanszaGry(planszaGry);
                    System.out.println(wynik);
                    end = true;
                    game = false;
                    break;
                }
            }
        }

        Main.doit();
    }

    public static void wypiszPlanszaGry(char [] [] planszaGry) {
        for(char [] row : planszaGry) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void ustawPionek(char [] [] planszaGry, int pozycja, String user) {

        char symbol = ' ';

        if(user.equals("Gracz")) {
            symbol = 'X';
            pozycjeGracza.add(pozycja);
        }else if (user.equals("Komputer")) {
            symbol = 'O';
            pozycjeKomputera.add(pozycja);
        }

        switch(pozycja) {
            case 1:
                planszaGry [0][0] = symbol;
                break;
            case 2:
                planszaGry [0][2] = symbol;
                break;
            case 3:
                planszaGry [0][4] = symbol;
                break;
            case 4:
                planszaGry [2][0] = symbol;
                break;
            case 5:
                planszaGry [2][2] = symbol;
                break;
            case 6:
                planszaGry [2][4] = symbol;
                break;
            case 7:
                planszaGry [4][0] = symbol;
                break;
            case 8:
                planszaGry [4][2] = symbol;
                break;
            case 9:
                planszaGry [4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String sprawdzWygrana() {

        List<Integer> gornyWiersz = Arrays.asList(1,2,3);
        List<Integer> srodkowyWiersz = Arrays.asList(4,5,6);
        List<Integer> dolnyWiersz = Arrays.asList(7,8,9);

        List<Integer> lewaKolumna = Arrays.asList(1,4,7);
        List<Integer> srodkowaKolumna = Arrays.asList(2,5,8);
        List<Integer> prawaKolumna = Arrays.asList(3,6,9);

        List<Integer> lewaDoPrawa = Arrays.asList(1,5,9);
        List<Integer> prawaDoLewa = Arrays.asList(3,5,7);

        List<List> czyWygrana = new ArrayList<>();
        czyWygrana.add(gornyWiersz);
        czyWygrana.add(srodkowyWiersz);
        czyWygrana.add(dolnyWiersz);
        czyWygrana.add(lewaKolumna);
        czyWygrana.add(srodkowaKolumna);
        czyWygrana.add(prawaKolumna);
        czyWygrana.add(lewaDoPrawa);
        czyWygrana.add(prawaDoLewa);

        for(List lista : czyWygrana) {
            if (pozycjeGracza.containsAll(lista)) {
                return "Wygrałeś";
            } else if (pozycjeKomputera.containsAll(lista)) {
                return "Przegrałeś";
            } else if (pozycjeGracza.size() + pozycjeKomputera.size() == 9 ) {
                return "REMIS";
            }
        }

        return "";

    }
}

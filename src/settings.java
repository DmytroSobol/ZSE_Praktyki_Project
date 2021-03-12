import java.io.IOException;
import java.util.Scanner;

public class settings {

    //Wyświetla informacje o użytkowniku i pozwala na zmiane w razie potrzeby
    public static void settings(String nazwa) throws IOException {
        new userinfo();
        System.out.println(userinfo.info(nazwa));

        System.out.println("Czy chcesz coś zmienić? (Tak czy Nie)");
        Scanner skaner = new Scanner(System.in);
        String i = skaner.next();

        if (i.equals("Tak") || i.equals("tak") || i.equals("t") || i.equals("T")){

            System.out.print("Wpisz swoje imie: ");
            String Name = skaner.next();
            userinfo.setName(Name, nazwa);

            System.out.print("Wpisz swoje nazwisko: ");
            String Surname = skaner.next();
            userinfo.setSurname(Surname, nazwa);

            try {
                System.out.print("Wpisz swój wiek: ");
                int Age = skaner.nextInt();
                userinfo.setAge(Age, nazwa);
            }catch (Exception exception){
                System.out.println("Podano nie liczbę");
            }
        }

        Main.status = 1;
        Main.doit();
    }
}

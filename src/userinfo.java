import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class userinfo {

    //Generacja numera konta
    public static int id;
    public static int setId(){
        Random random = new Random();
        do{
            id = random.nextInt(9999);
        }
        while (id < 1000);

        return id;
    }

    //Zmiana ustawień
    public static void setName(String Name, String nazwa) throws IOException {
        File file = new File("./src/"+ (nazwa) + "/name.txt");
        file.delete();

        try {

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(Name);
            pw.close();
        }

        catch (IOException e){
            System.out.println("Error");
        }
    }

    public static void setSurname(String Surname, String nazwa){
        File file = new File("./src/"+ (nazwa) + "/surname.txt");
        file.delete();

        try {

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(Surname);
            pw.close();
        }

        catch (IOException e){
            System.out.println("Error");
        }
    }

    public static void setAge(int Age, String nazwa){
        File file = new File("./src/"+ (nazwa) + "/age.txt");
        file.delete();

        try {

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(Age);
            pw.close();
        }

        catch (IOException e){
            System.out.println("Error");
        }
    }

    public static void setPass(String nazwa) throws IOException {
        Scanner skaner = new Scanner(System.in);

        System.out.print("Wpisz stare hasło: ");
        String haslo = skaner.next();

        File file = new File("./src/" + nazwa + "/haslo.txt");

        BufferedReader br;
        br = new BufferedReader( new FileReader(file));

        String line;
        while ((line = br.readLine()) != null){
            if(haslo.equals(line)){
                System.out.print("Wpisz nowe hasło: ");
                String newHaslo = skaner.next();

                file.delete();

                try {

                    if(!file.exists()){
                        file.createNewFile();
                    }
                    PrintWriter pw = new PrintWriter(file);
                    pw.println(newHaslo);
                    pw.close();
                }

                catch (IOException e){
                    System.out.println("Error");
                }

            }
        }
    }
    //Koniec zmiany ustawień

    //Stan konta
    public static String stan;
    public static int konto;

    public static int getAmount(String nazwa) throws IOException {
        File file;
        file = new File("./src/" + nazwa + "/amount.txt");

        BufferedReader br;
        br = new BufferedReader( new FileReader(file));

        while ((stan = br.readLine()) != null){
            konto = Integer.parseInt(stan);
        }
        return konto;
    }

    public static int setAmount(int kwota, String nazwa) throws IOException {
        File file = new File("./src/" + nazwa + "/amount.txt");

        BufferedReader br;
        br = new BufferedReader( new FileReader(file));


        file.delete();
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(kwota);
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }

        return kwota;
    }

    //Informacja o koncie
    public static String info(String nazwa) throws IOException {

        File file;
        file = new File("./src/" + nazwa + "/id.txt");

        BufferedReader br;
        br = new BufferedReader( new FileReader(file));

        String line;

        System.out.print("Twoje ID: ");
        while ((line = br.readLine()) != null){
            System.out.print(line + "\n");
        }

        file = new File("./src/" + nazwa + "/name.txt");

        br = new BufferedReader( new FileReader(file));
        System.out.print("Twoje imię: ");
        while ((line = br.readLine()) != null){
            System.out.print(line + "\n");
        }

        file = new File("./src/" + nazwa + "/surname.txt");

        br = new BufferedReader( new FileReader(file));
        System.out.print("Twoje nazwisko: ");
        while ((line = br.readLine()) != null){
             System.out.print(line + "\n");
         }

        file = new File("./src/" + nazwa + "/age.txt");

        br = new BufferedReader( new FileReader(file));

        System.out.print("Twój wiek: ");
        while ((line = br.readLine()) != null){
            parseInt(line);
            System.out.print(line + "\n");
        }

        String text = "Wyświetlono wszystkie twoje dane";

        return text;
    }

    //Informacja o samochodach
    public static void setCar(String car){
        String nazwa = login.nazwa;
        File file = new File("./src/"+ (nazwa) + "/cars.txt");
        file.delete();

        try {

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(car);
            pw.close();
        }

        catch (IOException e){
            System.out.println("Error");
        }
    }

    public static String getCar() throws IOException {
        String nazwa = login.nazwa;
        File file;
        file = new File("./src/" + nazwa + "/cars.txt");

        BufferedReader br;
        br = new BufferedReader( new FileReader(file));

        String car;
        while ((car = br.readLine()) != null){
            System.out.println(car);
        }
        return "";
    }
}

import java.io.*;

public class files {

    /*Część kodu, która odpowiada za tworzenie plików użytkownika
    Pobiera nazwe użytkownika z funkcji pliku login, następnie tworzy katalog o nazwie użytkownika i tworzy potrzebne pliki
    */
    public static void createFiles(String nazwa, String haslo) throws IOException {

        new File("./src/" + (nazwa)).mkdir();

        try {
            File file = new File("./src/"+ (nazwa) + "/login.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(nazwa);
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        try {
            File file = new File("./src/"+ (nazwa) + "/haslo.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(haslo);
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        try {
            File file = new File("./src/"+ (nazwa) + "/id.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println(userinfo.setId());
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        try {
            File file = new File("./src/"+ (nazwa) + "/amount.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("0");
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        try {
            File file = new File("./src/"+ (nazwa) + "/name.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("Nie podano");
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        try {
            File file = new File("./src/"+ (nazwa) + "/surname.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("Nie podano");
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        try {
            File file = new File("./src/"+ (nazwa) + "/age.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("0");
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
        try {
            File file = new File("./src/"+ (nazwa) + "/cars.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("Brak");
            pw.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }

    //Sprawdza czy istnieje podany przez użytkownika login i hasło

    public static void checkLogin(String nazwa) throws IOException {

        new login();

        File file = new File("./src/" + nazwa);
        if (file.exists()){
            login.status = true;
        }
        else {
            System.out.println("Takiego użytkownika nie znaleziono");
            login.status = false;
        }
    }

    public static void checkHaslo(String nazwa, String haslo) throws IOException {

        new login();

        File file = new File("./src/" + nazwa + "/haslo.txt");

        BufferedReader br;
        br = new BufferedReader( new FileReader(file));

        String line;
        while ((line = br.readLine()) != null){
            if(haslo.equals(line)){
                login.Log = true;
            }
        }
    }
}

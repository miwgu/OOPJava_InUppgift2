import java.util.List;
import java.util.Scanner;

/**
 * Created by Miwa Guhrés
 * Date: 2020-10-12
 * Time: 22:59
 * Project: OOPJava_2
 * Copyright: MIT
 */
public class Main {

    String filePath ="src\\"+"customers.txt";
    String outFile = "src\\" + "Training.txt";

    List<Person> personList = Database.readDataFromFile(filePath);
    List<Person> onlyMembersPersons = Logic.getAllMembersPersons(personList);
    boolean existActiv = false;
    boolean existDatabase = false;

    public Main() {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("***********************************************\n" +
                    "Söka medlemmar med personnummer eller namn \n" +
                    "Ange nummer\n" +
                    "1) Personnummer\n" +
                    "2) Namn\n" +
                    "3) Avbryt\n" +
                    "***********************************************\n");
            String nummer = sc.next().trim();

            //---Switch 1 personnummer, 2 namn eller 3 Avbryt-----
            switch (nummer) {
                case "1":
                    System.out.println("Ange personnummer (YYMMDDXXXX)");
                    sc = new Scanner(System.in);
                    String searchPersonNr = sc.next().trim();

                    for (Person m : onlyMembersPersons) {
                        if (m.getPersonNr().equals(searchPersonNr)) {
                            System.out.println(m.getName() + " är medlem");
                            Output.createFile(outFile, m.getName(), m.getPersonNr());
                            existActiv = true;
                            break;
                        } else
                            existActiv = false;

                    }
                    if (!existActiv)
                        for (Person p : personList) {
                            if (p.getPersonNr().equals(searchPersonNr)) {
                                System.out.println(p.getName() + " är inte medlem längre." + "\nDatum som årsavgiften betalades senast " + p.getDate());
                                existDatabase = true;
                                break;
                            } else
                                existDatabase = false;
                        }
                    if (!existDatabase && !existActiv)
                        System.out.println("Det finns inte personnummer: " + searchPersonNr + " som medlem.");
                    break;
                default:
                    System.out.println("Felaktig inmatning");
                    break;


                case "2":
                    System.out.println("Ange namn (Förnamn Eftername)");
                    sc = new Scanner(System.in);
                    String searchName = sc.nextLine().trim();

                    for (Person m : onlyMembersPersons) {
                        if (m.getName().equalsIgnoreCase(searchName)) {
                            System.out.println(m.getName() + " är medlem");
                            Output.createFile(outFile, m.getName(), m.getPersonNr());
                            existActiv = true;
                            break;
                        } else
                            existActiv = false;

                    }
                    if (!existActiv)
                        for (Person p : personList) {
                            if (p.getName().equalsIgnoreCase(searchName)) {
                                System.out.println(p.getName() + " är inte medlem längre." + "\nDatum som årsavgiften betalades senast " + p.getDate());
                                existDatabase = true;
                                break;
                            } else
                                existDatabase = false;

                        }
                    if (!existDatabase && !existActiv) // Man måste ange båda flag(boolean)
                        System.out.println("Det finns inte namn: " + searchName + " som medlem.");
                    break;

                case "3":
                    System.exit(0);
            }
        }
    }

    public static void main (String[]args){
        Main main = new Main();

    }
}

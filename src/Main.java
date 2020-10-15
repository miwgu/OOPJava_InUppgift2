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

    public Main() {
        Person person = new Person();
        String filePath = "src\\" + "customers.txt";
        String outFile = "src\\" + "Training.txt";

        List<Person> personList = Database.readDataFromFile(filePath);
        List<Person> onlyMembersPersons = Logic.getAllMembersPersons(personList);

    while (true) {
    Scanner sc = new Scanner(System.in);
    System.out.println("***********************************************\n" +
                    "Söka meddlemmer med personnummer eller namn \n"+
                    "Ange nummer\n"+
                    "1) Personnummer\n" +
                    "2) Namn\n"+
                    "3) Avbryt\n"+
                    "***********************************************\n"     );
    String nummer = sc.next().trim();

    //---Swich---
    boolean existActiv=false;
    boolean existDatabase=false;
    switch (nummer) {
        case "1":
            System.out.println("Ange personnummer");
            sc = new Scanner(System.in);
            String searchPersonNr = sc.next().trim();

            for (Person m : onlyMembersPersons) {
                if (m.getPersonNr().equals(searchPersonNr)) {
                    //p.getMessage();
                    System.out.println(m.getName() + " är medlemmer");
                    Output.createFile(outFile, m.getName(), m.getPersonNr());
                    existActiv = true;
                    break;
                } else
                    existActiv= false;

            }
            if (!existActiv)
                for (Person p : Database.readDataFromFile(filePath)) {
                    if (p.getPersonNr().equals(searchPersonNr)) {
                        System.out.println(p.getName() + " är inte medlemmer längre."+ "\nDatum som årsavgiften betalades senaste " + p.getDate());
                        existDatabase = true;
                        break;
                    } else
                        existDatabase = false;
                }
            if(!existDatabase&&!existActiv)
                System.out.println("Det finns inte personnummer: " + searchPersonNr + " som medlemmer.");// Det måste bara boolean...null eller det finnas
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
                    System.out.println(m.getName() + " är medlemmer");
                    Output.createFile(outFile, m.getName(), m.getPersonNr());
                    existActiv = true;
                    break;
                } else
                    existActiv = false;

            }
            if (!existActiv)
                for (Person p : Database.readDataFromFile(filePath)) {
                    if (p.getName().equalsIgnoreCase(searchName)) {
                        //p.getMessage();
                        System.out.println(p.getName() + " är inte medlemmer längre."+ "\nDatum som årsavgiften betalades senaste " + p.getDate());
                        existDatabase = true;
                        break;
                    } else
                        existDatabase = false;

                }
            if (!existDatabase&&!existActiv) // Man måste ange båda flag(boolean)
                System.out.println("Det finns inte namn: " + searchName + " som meddlem.");
            break;

        case"3":
            System.exit(0);
         }
    }
}

    public static void main (String[]args){
        Main main = new Main();

    }
}

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
        String outFile = "src\\" + "Training.text";

        List<Person> personList = Database.readDataFromFile(filePath);
        List<Person> onlyMembersPersons = Logic.getAllMembersPersons(personList);


        Scanner sc = new Scanner(System.in);
        System.out.println("Söka med personnummer-->1 eller namn-->2\nAnge nummer 1 eller 2");
        int nummer = sc.nextInt();

        //---Swich---
        boolean exist;
        switch (nummer) {
            case 1:
                System.out.println("Ange personnummer");
                //String s1 = JOptionPane.showInputDialog("Ange personnummer");
                sc = new Scanner(System.in);
                String searchPersonNr = sc.next();

                for (Person p : onlyMembersPersons) {
                    if (p.getPersonNr().equalsIgnoreCase(searchPersonNr)) {
                        p.getMessage();
                        Output.createFile(outFile,p.getName(),p.getPersonNr());
                        exist=true;
                        break;
                    }else
                        exist=false;
                }
                if(exist=false)
                    System.out.println("Det finns inte personnummer: " + searchPersonNr + " som meddlem.");// Det måste bara boolean...null eller det finnas
                break;
            case 2:
                System.out.println("Ange namn (Förnamn Eftername)");
                // String s2 = JOptionPane.showInputDialog("Ange namn");
                sc = new Scanner(System.in);
                String searchName = sc.nextLine();

                for (Person p : onlyMembersPersons) {
                    if (p.getName().equalsIgnoreCase(searchName)) {
                        p.getMessage();
                        Output.createFile(outFile,p.getName(),p.getPersonNr());
                        exist=true;
                        break;
                    }else
                        exist=false;
                }
                if(exist=false)
                    System.out.println("Det finns inte namn: " + searchName + " som meddlem.");
                break;
        }
    }
    public static void main (String[]args){
        Main main = new Main();

    }
}


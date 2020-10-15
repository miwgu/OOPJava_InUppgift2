import java.io.*;
import java.time.LocalDate;

/**
 * Created by Miwa Guhrés
 * Date: 2020-10-13
 * Time: 16:59
 * Project: OOPJava_2
 * Copyright: MIT
 */
public class Output {

    public static void createFile(String filename, String memberName,String memberPersonNr)  {

        try (PrintWriter ut = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {

            ut.println(memberPersonNr+","+memberName+","+LocalDate.now());
            System.out.println("Registrerad information: " + memberPersonNr+","+memberName+","+LocalDate.now());
            System.out.println("Filen har skapats");
        }catch (FileNotFoundException e){
            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Fel!: " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }catch (Exception e){
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }

    }

}

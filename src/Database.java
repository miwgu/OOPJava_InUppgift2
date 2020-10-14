import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Miwa Guhrés
 * Date: 2020-10-12
 * Time: 21:36
 * Project: OOPJava_2
 * Copyright: MIT
 */
public class Database {
    public static List<Person> readDataFromFile(String path_x){
        String firstLine;
        String secondLine;
        Path inFilePath;

        List<Person> personList = new ArrayList<>();
        String[] personDataPartsFirstLine = new String[2]; //7603021234, Alhambra Aromes
        //String[] personDataPartsFirstLineName=new String[2];
        String[] personDataPartsSecondLine= new String[1]; //2019-07-01
        inFilePath = Paths.get(path_x);
        try(Scanner fileScanner = new Scanner(inFilePath)){

            while(fileScanner.hasNext()){
                firstLine = fileScanner.nextLine();
                personDataPartsFirstLine = firstLine.split(",");
                if (fileScanner.hasNext()){
                    secondLine = fileScanner.nextLine();
                    personDataPartsSecondLine = secondLine.split(" ");
                }

                //for(String n:personDataPartsFirstLineName)


                Person p = new Person(personDataPartsFirstLine[0].trim(),//7603021234
                        personDataPartsFirstLine[1].trim(),//Alhambra Aromes
                        personDataPartsSecondLine[0].trim());//2019-07-01

                personList.add(p);
            }
        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return personList;
    }
}

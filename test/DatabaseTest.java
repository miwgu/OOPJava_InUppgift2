import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Miwa Guhrés
 * Date: 2020-10-15
 * Time: 13:33
 * Project: Inlämningsuppgift2
 * Copyright: MIT
 */
public class DatabaseTest {

    Database db=new Database();
    String inFile= "test/customersTest.txt";
    List<Person> persons=db.readDataFromFile(inFile);

    //För att testa data i ArrayList som läser in från filen är samma som nedan(samma data som i filen) eller inte
    Person p1=new Person("7603021234","Alhambra Aromes", "2019-07-01");
    Person p2=new Person("7608021234","Diamanda Djedi","2020-01-30");
    Person p3=new Person("7512166544","Greger Ganache","2020-03-23");
    Person p4=new Person("8906138493","Ida Idylle","2017-03-07");
    Person p5=new Person("7805211234","Nahema Ninsson","2020-08-04");

    List<Person> testPersons=new ArrayList<>();


    @Test
    public final void readDataFromFileTest(){
        testPersons= Arrays.asList(p1,p2,p3,p4,p5);

        assertTrue(persons.size()==5);
        assertFalse(persons.size()==6);

        assertTrue(persons.get(0).getPersonNr().equals(testPersons.get(0).getPersonNr()));
        assertFalse(persons.get(0).getPersonNr().equals(testPersons.get(2).getPersonNr()));
    }


}

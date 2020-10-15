import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Miwa Guhrés
 * Date: 2020-10-15
 * Time: 15:08
 * Project: Inlämningsuppgift2
 * Copyright: MIT
 */
public class LogicTest {

    Logic l= new Logic();

    Person p1=new Person("7603021234","Alhambra Aromes", "2019-07-01");
    Person p2=new Person("7608021234","Diamanda Djedi","2020-01-30");
    Person p3=new Person("7512166544","Greger Ganache","2020-03-23");
    Person p4=new Person("8906138493","Ida Idylle","2017-03-07");
    Person p5=new Person("7805211234","Nahema Ninsson","2020-08-04");

    List<Person> testPersons=new ArrayList<>();
    List<Person> activMembers=new ArrayList<>();

    @Test
    public final void getAllMembersPersonsTest(){
        testPersons= Arrays.asList(p1,p2,p3,p4,p5);
        activMembers=l.getAllMembersPersons(testPersons);

        assertTrue(activMembers.size()==3);
        assertFalse(activMembers.size()==1);

        assertTrue(activMembers.get(0).getPersonNr().equals("7608021234"));
        assertTrue(activMembers.get(0).getName().equals("Diamanda Djedi"));
        assertTrue(activMembers.get(0).getDate().equals("2020-01-30"));
        assertFalse(activMembers.get(0).getPersonNr().equals("7603021234"));
        assertFalse(activMembers.get(0).getName().equals("Alhambra Aromes"));
        assertFalse(activMembers.get(0).getDate().equals("2019-07-01"));

        assertTrue(activMembers.get(2).getPersonNr().equals("7805211234"));
        assertTrue(activMembers.get(2).getName().equals("Nahema Ninsson"));
        assertTrue(activMembers.get(2).getDate().equals("2020-08-04"));
        assertTrue(activMembers.get(1).getPersonNr().equals("7512166544"));
        assertTrue(activMembers.get(1).getName().equals("Greger Ganache"));
        assertTrue(activMembers.get(1).getDate().equals("2020-03-23"));
        assertFalse(activMembers.get(2).getPersonNr().equals("7512166544"));
        assertFalse(activMembers.get(2).getName().equals("Greger Ganache"));
        assertFalse(activMembers.get(2).getDate().equals("2020-03-23"));

    }

}


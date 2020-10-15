import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Miwa Guhrés
 * Date: 2020-10-15
 * Time: 13:09
 * Project: Inlämningsuppgift2
 * Copyright: MIT
 */
public class PersonTest {

    Person p=new Person("7603021234","Alhambra Aromes","2019-07-01");

    @Test
    public final void getPersonNrTest(){
        assertTrue(p.getPersonNr().equals("7603021234"));
        assertFalse(p.getName().equals("9603021234"));

    }
    @Test
    public final void getName(){
        assertTrue(p.getName().equalsIgnoreCase("alhamBra AromeS"));
        assertFalse(p.getName().equalsIgnoreCase("Bear AromeS"));
        assertFalse(p.getName().equalsIgnoreCase("alhamBra    AromeS"));
    }
    @Test
    public final void getDateTest(){
        assertTrue(p.getDate().equals("2019-07-01"));
        assertFalse(p.getDate().equals("2019-12-01"));

    }


}

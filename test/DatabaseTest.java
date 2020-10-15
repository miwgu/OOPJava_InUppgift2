import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


    @Test
    public final void readDataFromFileTest(){
        List<Person> persons=db.readDataFromFile(inFile);
        assertTrue(persons.size()==5);
        assertFalse(persons.size()==6);
    }


}

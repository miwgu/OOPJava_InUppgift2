import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Miwa Guhrés
 * Date: 2020-10-15
 * Time: 14:19
 * Project: Inlämningsuppgift2
 * Copyright: MIT
 */
public class OutputTest {
    String outFile="test/TrainingTest.txt";

    public final int contLinesInfile(String fileToCount ){
        int lines=0;
        try(BufferedReader reader=new BufferedReader(new FileReader(fileToCount));){
            while (reader.readLine()!=null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Test
    public final void createFileFileTest(){
        Person p1=new Person("7603021234","Alhambra Aromes", "2019-07-01");
        Person p2=new Person("7608021234","Diamanda Djedi","2020-01-30");
        Person p3=new Person("7512166544","Greger Ganache","2020-03-23");
        Person p4=new Person("8906138493","Ida Idylle","2017-03-07");
        Person p5=new Person("7805211234","Nahema Ninsson","2020-08-04");


        Output.createFile(outFile,p1.getName(),p1.getPersonNr());
        assertTrue(contLinesInfile(outFile)==1);
        assertFalse(contLinesInfile(outFile)==0);
        Output.createFile(outFile,p2.getName(),p2.getPersonNr());
        assertTrue(contLinesInfile(outFile)==2);
        assertFalse(contLinesInfile(outFile)==1);
        Output.createFile(outFile,p3.getName(),p3.getPersonNr());
        assertTrue(contLinesInfile(outFile)==3);
        assertFalse(contLinesInfile(outFile)==0);
        Output.createFile(outFile,p4.getName(),p4.getPersonNr());
        assertTrue(contLinesInfile(outFile)==4);
        assertFalse(contLinesInfile(outFile)==0);
        Output.createFile(outFile,p5.getName(),p5.getPersonNr());
        assertTrue(contLinesInfile(outFile)==5);
        assertFalse(contLinesInfile(outFile)==1);




    }
}

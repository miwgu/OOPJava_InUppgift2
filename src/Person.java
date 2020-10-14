
/**
 * Created by Miwa Guhrés
 * Date: 2020-10-12
 * Time: 18:57
 * Project: OOPJava_2
 * Copyright: MIT
 */
public class Person {
    protected String personNr;
    protected String name;
    protected String date;

    Person(){}

    public Person(String personNr, String name, String date) {
        this.personNr = personNr;
        this.name = name;
        this.date = date;
    }

    public String getPersonNr() {
        return personNr;
    }


    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return String.format("Personnummer %s  %s är medlemmer.", this.personNr, this.name);
    }
}

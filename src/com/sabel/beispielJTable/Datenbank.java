package com.sabel.beispielJTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by m.strohmayer on 08.05.2017.
 */
public class Datenbank {

    private List<Person> personen;

    public Datenbank() {
        this.personen = new ArrayList<>();
    }

    public void hinzufuegen(Person person) {
        if (person != null) {
            this.personen.add(person);
        }
    }

    public Person loeschePerson(String uuid) {
        Iterator<Person> iterator = personen.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getUuid().toString().equals(uuid)) {
                iterator.remove();
                return person;
            }
        }
        return null;
    }

    public Person findePerson(int index) {
        return personen.get(index);
    }

    public Person findePerson(String name) {
        Iterator<Person> iterator = personen.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public int size() {
        return personen.size();
    }

    public static Datenbank erzeugeTestDatenbank() {
        Datenbank db = new Datenbank();
        db.hinzufuegen(new Person ("Meier",40));
        db.hinzufuegen(new Person ("Müller", 25));
        return db;
    }
}

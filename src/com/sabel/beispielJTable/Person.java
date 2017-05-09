package com.sabel.beispielJTable;

import java.util.UUID;

/**
 * Created by m.strohmayer on 08.05.2017.
 */
public class Person {
    private UUID uuid;
    private String name;
    private int alter;

    public Person() {
        uuid = UUID.randomUUID();
    }



    public Person(String name, int alter) {
        this();
        this.name = name;
        this.alter = alter;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (alter != person.alter) return false;
        if (uuid != null ? !uuid.equals(person.uuid) : person.uuid != null) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + alter;
        return result;
    }
}

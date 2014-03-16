package com.peopledb.entity;

import javax.persistence.*;

/**
 * Created by Oleg on 16.03.14.
 */
@Entity
@Table(name="Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    @Column(unique = true)
    private String name;

    public Person() {
    }

    public Person(int personId, String name) {
        this.personId = personId;
        this.name = name;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}

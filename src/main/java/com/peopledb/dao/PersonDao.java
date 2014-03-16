package com.peopledb.dao;

import com.peopledb.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Oleg on 16.03.14.
 */
@Repository
public class PersonDao {
    @PersistenceContext
    private EntityManager em;

    public PersonDao() {
    }

    public void savePerson(Person person) {
        em.persist(person);
    }

    public Person findByName(String name) {
        return (Person)em.createQuery("SELECT p FROM Person p WHERE p.name=:name").setParameter("name",name).getSingleResult();
    }

    public List<Person> findAllPersons() {
        return (List<Person>)em.createQuery("SELECT p FROM Person p").getResultList();
    }
}

package com.peopledb.service;

import com.peopledb.dao.PersonDao;
import com.peopledb.entity.Address;
import com.peopledb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Oleg on 16.03.14.
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public Person createPerson(String name) {
        Person person = new Person();
        person.setName(name);
        personDao.savePerson(person);
        return person;
    }

    @Transactional
    public void createPerson(String name, Address address) {
        Person person = new Person();
        person.setName(name);
        person.setAddress(address);
        personDao.savePerson(person);
    }

    @Transactional
    public Person findPerson(String name) {
        return personDao.findByName(name);
    }

    @Transactional
    public List<Person> findAllPersons() {
        return personDao.findAllPersons();
    }
}

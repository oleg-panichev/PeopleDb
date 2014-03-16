package com.peopledb.dao;

import com.peopledb.entity.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Oleg on 16.03.14.
 */
@Repository
public class AddressDao {
    @PersistenceContext
    private EntityManager em;

    public AddressDao() {
    }

    public void saveAddress(Address address) {
        em.persist(address);
    }

    public Address findByFullAddress(String fullAddress) {
        return (Address)em.createQuery("SELECT a FROM Address a WHERE a.fullAddress=:fullAddress").setParameter("fullAddress",fullAddress).getSingleResult();
    }

    public List<Address> findAllAddresses() {
        return (List<Address>)em.createQuery("SELECT a FROM Address a").getResultList();
    }
}

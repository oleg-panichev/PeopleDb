package com.peopledb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Oleg on 16.03.14.
 */
@Entity
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @Column(unique = true)
    private String fullAddress;
    @OneToMany(mappedBy="person")
    private Collection<Person> inhabitants = new ArrayList<Person>();

    public Address() {
    }

    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Collection<Person> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(Collection<Person> inhabitants) {
        this.inhabitants = inhabitants;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}

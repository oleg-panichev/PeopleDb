package com.peopledb.service;

import com.peopledb.dao.AddressDao;
import com.peopledb.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Oleg on 16.03.14.
 */
@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    @Transactional
    public Address createAddress(String fullAddress) {
        Address address = new Address();
        address.setFullAddress(fullAddress);
        addressDao.saveAddress(address);
        return address;
    }

    @Transactional
    public Address findAddress(String fullAddress) {
        return addressDao.findByFullAddress(fullAddress);
    }

    @Transactional
    public List<Address> findAllAddresses() {
        return addressDao.findAllAddresses();
    }
}

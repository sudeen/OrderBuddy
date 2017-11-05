package com.sudin.Service.impls.RestaurantServiceImpls;

import com.sudin.Entity.RestaurantEntity.Contact;
import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Repository.RestaurantRepository.ContactRepository;
import com.sudin.Repository.RestaurantRepository.RestaurantRepository;
import com.sudin.Service.RestaurantServices.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);


    @Autowired
    private ContactRepository contactRepository;




    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void remove(Long id) {
        contactRepository.delete(id);
    }
}

package com.sudin.Service.contact;

import com.sudin.Entity.Contact;
import com.sudin.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact findByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    @Override
    public void remove(Long id) {
        contactRepository.delete(id);
    }
}

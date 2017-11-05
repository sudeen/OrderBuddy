package com.sudin.Service.contact;

import com.sudin.Entity.Contact;

import java.util.List;


public interface ContactService {

    List<Contact> findAll();

    Contact findById(Long id);

    Contact save(Contact contact);

    void remove(Long id);

}

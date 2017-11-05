package com.sudin.Controllers.RestaurantControllers;

import com.sudin.Entity.RestaurantEntity.Contact;
import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Pojo.ContactPojo;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Pojo.RestaurantPojo;
import com.sudin.Repository.RestaurantRepository.ContactRepository;
import com.sudin.Repository.RestaurantRepository.RestaurantRepository;
import com.sudin.Service.RestaurantServices.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/contact")
public class ContactController {


    @Autowired
    ContactService contactService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    EntityManager entityManager;

    //TO MAKE DEFAULT RESPOND
    private GlobalResponse respond(String status, String message, Object data) {
        return new GlobalResponse(status, message, data);
    }

    @RequestMapping(value = "/findAllContact")
    @ResponseBody
    public GlobalResponse findAllContact() {
        try {
            return respond("success", "All Contacts", contactRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return respond("Fail", "Failed to Load", null);
        }
    }

    @RequestMapping(value = "/addContact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addContactPost(@RequestBody Contact contact) {
        try {
            return respond("Success", "New Contact Added", contactService.save(contact));
        } catch (Exception e) {
            e.printStackTrace();
            return respond("Fail", "Failed to load", null);
        }
    }

    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContact(@PathVariable Long id) {
        contactService.remove(id);
    }


    @RequestMapping(value = "/findContact/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse getContactById(@PathVariable("id") Long id) {
        try {
            return respond("Success", "Contact Id " + id, contactService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return respond("Fail", "Failed to load", null);
        }
    }


    @RequestMapping(value = "/updateContact/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateContact(@RequestBody ContactPojo contactPojo,
                                        @PathVariable("id") Long id) {

        try {
            Contact contact = new Contact();
            contact.setId(contactPojo.getContactId());
            contact.setEmail(contactPojo.getEmail());
            contact.setMobileNumber(contactPojo.getMobileNumber());
            contact.setLandlineNumber(contactPojo.getLandlineNumber());
            contact.setLocation(contactPojo.getLocation());
            return respond("Success", "Contact " + id + " Updated", contactService.save(contact));
        } catch (Exception e) {
            e.printStackTrace();
            return respond("Fail", "Failed to Load", null);
        }
    }


}

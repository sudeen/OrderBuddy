package com.sudin.Controllers;

import com.sudin.Entity.Contact;
import com.sudin.Pojo.ContactPojo;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Repository.ContactRepository;
import com.sudin.Repository.RestaurantRepository;
import com.sudin.Service.contact.ContactService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
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
            return respond(Constant.SUCCESS_MESSAGE, "All Contacts", contactRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

    @RequestMapping(value = "/addContact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addContactPost(@RequestBody Contact contact) {
        try {
            return respond(Constant.SUCCESS_MESSAGE, "New Contact Added", contactService.save(contact));
        } catch (Exception e) {
            e.printStackTrace();
            return respond(Constant.ERROR_MESSAGE, "Failed to load", null);
        }
    }

    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContact(@PathVariable Long id) {
        contactService.remove(id);
    }

    @RequestMapping(value = "/findContact/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public GlobalResponse getContactById(@PathVariable("id") Long id) {
        try {
            return respond(Constant.SUCCESS_MESSAGE, "Contact Id " + id, contactService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return respond(Constant.ERROR_MESSAGE, "Failed to load", null);
        }
    }

    @RequestMapping(value = "/updateContact/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @ResponseBody
    public GlobalResponse updateContact(@RequestBody ContactPojo contactPojo, @PathVariable("id") Long id) {
        Contact currentContact = contactService.findById(id);
        if (currentContact != null) {
            try {
                Contact contact = new Contact();
                contact.setId(id);
                contact.setEmail(BaseUtils.nullValueAlternative(contactPojo.getEmail(), currentContact.getEmail()));
                contact.setMobileNumber(BaseUtils.nullValueAlternative(contactPojo.getMobileNumber(), currentContact.getMobileNumber()));
                contact.setLandlineNumber(BaseUtils.nullValueAlternative(contactPojo.getLandlineNumber(), currentContact.getLandlineNumber()));
                contact.setLocation(BaseUtils.nullValueAlternative(contactPojo.getLocation(), currentContact.getLocation()));

                return respond(Constant.SUCCESS_MESSAGE, "Contact " + id + " Updated", contactService.save(contact));
            } catch (Exception e) {
                e.printStackTrace();
                return respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
            }
        } else {
            return respond(Constant.ERROR_MESSAGE, "No contact with id " + id + " found", null);
        }
    }



}

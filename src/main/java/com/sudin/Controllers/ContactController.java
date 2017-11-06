package com.sudin.Controllers;

import com.sudin.Entity.Contact;
import com.sudin.Pojo.ContactPojo;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Service.contact.ContactService;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/findAllContact")
    @ResponseBody
    public GlobalResponse findAllContact() {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "All Contacts", contactService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to Load", null);
        }
    }

    @RequestMapping(value = "/addContact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addContact(@RequestBody Contact contact) {
        Contact c = contactService.findByEmail(contact.getEmail());
        if (c == null) {
            try {
                return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Successfully added Contact", contactService.save(contact));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to create contact.", null);
            }
        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Email already taken", null);
        }
    }

    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContact(@PathVariable Long id) {
        contactService.remove(id);
    }

    @RequestMapping(value = "/findContact/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public GlobalResponse getContactById(@PathVariable("id") Long contactId) {
        try {
            return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Contact Id " + contactId, contactService.findById(contactId));
        } catch (Exception e) {
            e.printStackTrace();
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "Contact not found", null);
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

                return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Contact " + id + " Updated", contactService.save(contact));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseUtils.respond(Constant.ERROR_MESSAGE, "Failed to update contact", null);
            }
        } else {
            return BaseUtils.respond(Constant.ERROR_MESSAGE, "No contact with id " + id + " found", null);
        }
    }

}

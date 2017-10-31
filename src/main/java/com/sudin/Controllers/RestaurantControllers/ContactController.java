package com.sudin.Controllers.RestaurantControllers;

import com.sudin.Entity.RestaurantEntity.Contact;
import com.sudin.Entity.RestaurantEntity.Restaurant;
import com.sudin.Pojo.GlobalResponse;
import com.sudin.Service.RestaurantServices.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {


    @Autowired
    ContactService contactService;

    //TO MAKE DEFAULT RESPOND
    private GlobalResponse respond(String status, String message, Object data) {
        return new GlobalResponse(status, message, data);
    }


    @RequestMapping(value = "/addContact",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public GlobalResponse addContactPost(@RequestBody Contact contact){
        try {
            return respond("Success","Successfully loaded",contactService.save(contact));
        } catch (Exception e) {
            e.printStackTrace();
            return respond("Fail","Failed to load",null);
        }
    }

    @RequestMapping(value = "/deleteContact/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContact(@PathVariable Long id){
        contactService.remove(id);
    }


}

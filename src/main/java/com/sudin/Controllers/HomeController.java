package com.sudin.Controllers;


import com.sudin.Pojo.GlobalResponse;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

//    @RequestMapping(value = "/")
//    @ResponseBody
//    public GlobalResponse home() {
//        return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Hello Order Buddy", null);
//    }


    @RequestMapping("/")
    public String index() {
        return "login";
    }

    // Added to test 500 page
    @RequestMapping(path = "/tigger-error", produces = MediaType.APPLICATION_JSON_VALUE)
    public void error500() throws Exception {
        throw new Exception();
    }

}

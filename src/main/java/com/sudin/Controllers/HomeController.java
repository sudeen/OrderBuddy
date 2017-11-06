package com.sudin.Controllers;


import com.sudin.Pojo.GlobalResponse;
import com.sudin.Utils.BaseUtils;
import com.sudin.Utils.Constant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    @ResponseBody
    public GlobalResponse home() {
        return BaseUtils.respond(Constant.SUCCESS_MESSAGE, "Hello Order Buddy", null);
    }
}

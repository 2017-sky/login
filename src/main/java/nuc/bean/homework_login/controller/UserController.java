package nuc.bean.homework_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login1")
    public String login1(){
        return "success.html";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

package com.srcb.cmis.login;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "security/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register()
    {
        return "security/register";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String index()
    {
        return "register success!";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    @ResponseBody
    public String welcome(@RequestParam(value="userName") String userName,@RequestParam(value="password") String password)
    {
        return "Hello,"+userName;
    }
}

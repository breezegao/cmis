package com.example.demo.web;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class HelloWorldController {

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
    @ResponseBody()
    String getUserByGet(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String index(){
        return "hello";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/welcome")
    @ResponseBody()
    public String welcome(@RequestParam(value = "userName") String userName) {

        //return "welcome";
        return "Hello,"+userName;
    }
    @RequestMapping(  value = "/hello")
    @ResponseBody()
    public ModelAndView welcomes() {
        ModelAndView mode = new ModelAndView();
        mode.setViewName("hello");
        return mode;
    }


}

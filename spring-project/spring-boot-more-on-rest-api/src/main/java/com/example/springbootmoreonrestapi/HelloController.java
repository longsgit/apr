package com.example.springbootmoreonrestapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Used to develop web applications
//All the methods return View information
@Controller
public class HelloController {

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye";
        //Bye is not "data"
        //Bye is information about a view
        //Bye has to be resolved to say Bye.html or Bye.jsp or Bye.pdf etc
    }
}

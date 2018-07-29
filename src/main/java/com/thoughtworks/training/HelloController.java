package com.thoughtworks.training;

import com.thoughtworks.training.model.Person;
import com.thoughtworks.training.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    String hello(@PathVariable String name, @RequestParam String from, Model model) {
        Person person = new Person(name, from);
        model.addAttribute("person", person);
        model.addAttribute("greetings", helloService.list());
        return "hello";
    }

}

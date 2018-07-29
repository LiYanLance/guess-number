package com.thoughtworks.training;

import com.thoughtworks.training.model.Person;
import com.thoughtworks.training.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    ResponseEntity<Person> hello(@PathVariable String name,
                                 @RequestParam String from) {
        Person person = new Person(name, from);

        return ResponseEntity.ok(person);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    List<String> grettings() {
        return helloService.list();
    }

}

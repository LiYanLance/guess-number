package com.thoughtworks.training.service;

import com.google.common.collect.Lists;
import com.thoughtworks.training.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HelloService {
    @Autowired
    private HelloRepository helloRepository;

    public List<String> list() {
        ArrayList<String> greetings = Lists.newArrayList(helloRepository.listGreetings());
        Collections.shuffle(greetings);
        return greetings.subList(0, 5);
    }
}

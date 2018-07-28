package com.thoughtworks.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
    @Autowired
    private MovieLister movieLister;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(movieLister.find("Godfather"));
    }
}

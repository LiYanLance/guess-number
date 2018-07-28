package com.thoughtworks.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

@SpringBootApplication
public class SpringApp implements ApplicationRunner {
    @Autowired
    NumberProcessor processor;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        String line;
        while ((line = in.readLine()).length() != 0) {
            System.out.println(processor.process(line));
        }

    }
}

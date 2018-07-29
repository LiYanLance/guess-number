package com.thoughtworks.training;

import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringAppRunner implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) {
        MovieLister movieLister = context.getBean(MovieLister.class);
        System.out.println(movieLister.find("Godfather"));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}

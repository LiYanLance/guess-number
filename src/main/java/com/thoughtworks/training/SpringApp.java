package com.thoughtworks.training;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

public class SpringApp {
    public static void main(String[] args) {
        traditionalWay();
        springWay();
    }

    private static void springWay() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("context.xml"));
        MovieLister lister = beanFactory.getBean(MovieLister.class);
        List<String> results = lister.find("Godfather");
        System.out.println(String.format("spring find: %s", results));
    }

    public static void traditionalWay() {
        MovieLister lister = new MovieLister(ImmutableList.of(new MovieFinderImpl()));
        List<String> results = lister.find("Godfather");
        System.out.println(String.format("we find: %s", results));
    }
}

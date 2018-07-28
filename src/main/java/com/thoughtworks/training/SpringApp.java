package com.thoughtworks.training;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class SpringApp {

    public static void main(String[] args) throws IOException {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("context.xml"));
        NumberProcessor processor = beanFactory.getBean(NumberProcessor.class);

        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        String line;
        while ((line = in.readLine()).length() != 0) {
            System.out.println(processor.process(line));
        }
    }
}

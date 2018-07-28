package com.thoughtworks.training;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

public class SpringApp {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws IOException {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("context.xml"));
        Processor processor = beanFactory.getBean(Processor.class);
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        String line;
        while ((line = in.readLine()).length() != 0) {
            List<String> process = processor.process(line);
            System.out.println(process);
        }
    }
}

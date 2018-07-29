package com.thoughtworks.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {
    public Person(String name, String from) {
        this.name = name;
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    private String name;

    @JsonIgnore
    private String from;
}

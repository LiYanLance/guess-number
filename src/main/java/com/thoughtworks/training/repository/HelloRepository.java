package com.thoughtworks.training.repository;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HelloRepository {

    private List<String> greetings = ImmutableList.of(
            "你好",
            "bonjour",
            "こんにちは",
            "Привет",
            "Merhaba",
            "chào",
            "Ciao",
            "Γειά",
            "halo");

    public List<String> listGreetings() {
        return greetings;
    }


}

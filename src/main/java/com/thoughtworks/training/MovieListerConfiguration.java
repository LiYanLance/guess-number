package com.thoughtworks.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class MovieListerConfiguration {

    @Bean
    public MovieFinder movieFinder() {
        return new MovieFinderImpl();
    }
}

package com.thoughtworks.training;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Order(1)
@Profile("odd")
@Component
public class OddFilter implements Processor {
    @Override
    public List<Integer> process(List<Integer> input) {
        return input.stream().filter(value -> value % 2 != 0)
                .collect(Collectors.toList());
    }

}
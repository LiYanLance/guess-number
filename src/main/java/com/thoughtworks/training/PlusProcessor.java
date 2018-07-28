package com.thoughtworks.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Profile("plus")
@Order(2)
@Component
public class PlusProcessor implements Processor {

    private final int operand;

    public PlusProcessor(@Value("${plus.operand}") int operand) {
        this.operand = operand;
    }

    @Override
    public List<Integer> process(List<Integer> input) {
        return input.stream().map(value -> value + operand)
                .collect(Collectors.toList());
    }

}

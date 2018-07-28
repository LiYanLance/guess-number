package com.thoughtworks.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Profile("multiply")
@Component
public class MultiplyProcessor implements Processor {

    private final int operand;

    public MultiplyProcessor(@Value("${multiply.operand}") int operand) {
        this.operand = operand;
    }

    @Override
    public List<Integer> process(List<Integer> input) {
        return input.stream().map(value -> value * operand)
                .collect(Collectors.toList());
    }

}

package com.thoughtworks.training;

import java.util.List;
import java.util.stream.Collectors;

public class MultiplyProcessor implements Processor {

    private final int operand;

    public MultiplyProcessor(int operand) {
        this.operand = operand;
    }

    @Override
    public List<Integer> process(List<Integer> input) {
        return input.stream().map(value -> value * operand)
                .collect(Collectors.toList());
    }

}

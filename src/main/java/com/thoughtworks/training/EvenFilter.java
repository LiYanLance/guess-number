package com.thoughtworks.training;

import java.util.List;
import java.util.stream.Collectors;

public class EvenFilter implements Processor {
    @Override
    public List<Integer> process(List<Integer> input) {
        return input.stream().filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
    }

}

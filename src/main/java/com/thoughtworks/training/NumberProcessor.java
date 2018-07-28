package com.thoughtworks.training;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NumberProcessor {

    public NumberProcessor(List<Processor> processors) {
        this.processors = processors;
    }

    List<Processor> processors;

    String process(String input) {
        List<Integer> values = Lists.newArrayList(input.split(" "))
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Processor processor : processors) {
            values = processor.process(values);
        }

        return String.join(" ",
                values.stream().map(String::valueOf).collect(Collectors.toList()));
    }
}

package com.thoughtworks.training;

import java.util.List;

public class PassThroughProcessor implements Processor {
    @Override
    public List<String> process(List<String> input) {
        return input;
    }
}

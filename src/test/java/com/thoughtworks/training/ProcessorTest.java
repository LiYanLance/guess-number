package com.thoughtworks.training;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProcessorTest {

    private final List<Integer> input = IntStream.range(1, 6)
            .boxed().collect(Collectors.toList());

    @Test
    public void shouldPlusInputValues() {
        Processor processor = new PlusProcessor(2);
        List<Integer> output = IntStream.of(3, 4, 5, 6, 7)
                .boxed().collect(Collectors.toList());
        assertThat(processor.process(input), is(output));
    }

    @Test
    public void shouldMultiplyInputValues() {
        Processor processor = new MultiplyProcessor(2);
        List<Integer> output = IntStream.of(2, 4, 6, 8, 10)
                .boxed().collect(Collectors.toList());
        assertThat(processor.process(input), is(output));
    }

    @Test
    public void shouldDivideInputValues() {
        Processor processor = new DivideProcessor(2);
        List<Integer> output = IntStream.of(0, 1, 1, 2, 2)
                .boxed().collect(Collectors.toList());
        assertThat(processor.process(input), is(output));
    }

    @Test
    public void shouldFilterEvenValues() {
        Processor processor = new EvenFilter();
        List<Integer> output = IntStream.of(2, 4)
                .boxed().collect(Collectors.toList());
        assertThat(processor.process(input), is(output));
    }

    @Test
    public void shouldFilterOddValues() {
        Processor processor = new OddFilter();
        List<Integer> output = IntStream.of(1, 3, 5)
                .boxed().collect(Collectors.toList());
        assertThat(processor.process(input), is(output));
    }
}
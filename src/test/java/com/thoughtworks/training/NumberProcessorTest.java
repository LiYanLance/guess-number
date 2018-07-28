package com.thoughtworks.training;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.mockito.InOrder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NumberProcessorTest {

    @Test
    public void shouldSplitInputValueAndCallProcessors() {
        Processor secondProcessor = mock(Processor.class);
        Processor firstProcessor = secondProcessor;
        when(firstProcessor.process(eq(ImmutableList.of(1, 2, 3, 4, 5))))
                .thenReturn(ImmutableList.of(1, 3, 5));
        when(secondProcessor.process(ImmutableList.of(1, 3, 5)))
                .thenReturn(ImmutableList.of(2, 4, 6));
        NumberProcessor numberProcessor = new NumberProcessor(ImmutableList.of(firstProcessor, secondProcessor));
        InOrder inOrder = inOrder(firstProcessor, secondProcessor);

        assertThat(numberProcessor.process("1 2 3 4 5"), is("2 4 6"));
        inOrder.verify(firstProcessor, times(1)).process(ImmutableList.of(1, 2, 3, 4, 5));
        inOrder.verify(secondProcessor, times(1)).process(ImmutableList.of(1, 3, 5));
    }
}
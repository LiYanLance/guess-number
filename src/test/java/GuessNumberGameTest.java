import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GuessNumberGameTest {

    @Test
    public void shouldReturnAllOddNumbers() {
        String output = new GuessNumberGame(
                ImmutableList.of(
                        new FilterRule(number -> number % 2 != 0)
                )
        ).process("1 2 3 4 5");
        assertThat(output, is("1 3 5"));
    }

    @Test
    public void shouldReturnOddNumberTime2Plus1() {
        String output = new GuessNumberGame(
                ImmutableList.of(
                        new FilterRule(number -> number % 2 != 0),
                        new OperateRule(number -> number * 2),
                        new OperateRule(number -> number + 1)
                )
        ).process("1 2 3 4 5");
        assertThat(output, is("3 7 11"));
    }


    @Test
    public void shouldReturnEvenDividedBy2() {
        String output = new GuessNumberGame(ImmutableList.of(
                new FilterRule(number -> number % 2 == 0),
                new OperateRule(number -> number / 2)
        )).process("1 2 3 4 5");
        assertThat(output, is("1 2"));
    }

    @Test
    public void shouldReturnOddPlus2() {
        String output = new GuessNumberGame(ImmutableList.of(
                new FilterRule(number -> number % 2 != 0),
                new OperateRule(number -> number + 2)
        )).process("1 2 3 4 5");
        assertThat(output, is("3 5 7"));
    }
}
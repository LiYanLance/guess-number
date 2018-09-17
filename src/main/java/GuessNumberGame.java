import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GuessNumberGame {

    private List<Rule> rules;

    public GuessNumberGame(List<Rule> rules) {
        this.rules = rules;
    }

    public String process(String input) {
        List<Integer> integers = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> outputNumbers = process(integers);

        return  outputNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private List<Integer> process(List<Integer> integers) {
        List<Integer> result = integers;
        for (Rule rule : rules) {
            result = rule.apply(result);
        }
        return result;
    }


}

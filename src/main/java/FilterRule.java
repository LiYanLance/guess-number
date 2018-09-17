import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterRule implements Rule {

    private Predicate<Integer> rule;

    public FilterRule(Predicate<Integer> rule) {
        this.rule = rule;
    }

    @Override
    public List<Integer> apply(List<Integer> integers) {
        return integers.stream().filter(rule).collect(Collectors.toList());
    }
}

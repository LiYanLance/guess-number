import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperateRule implements Rule {

    private Function<Integer, Integer> rule;

    public OperateRule(Function<Integer, Integer> rule) {
        this.rule = rule;
    }

    @Override
    public List<Integer> apply(List<Integer> integers) {
        return integers.stream().map(rule).collect(Collectors.toList());
    }
}

import expression.Expression;

import java.util.Queue;

public interface Evaluator {
    public double evaluate(Queue<Expression> q, double x) throws Exception;
}

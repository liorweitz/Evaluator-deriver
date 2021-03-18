import expression.Expression;

import java.util.Queue;

public interface Evaluator {
    /**
     * evaluates the equation value given a specific x value.
     * @param q the equation in postFix notation.
     * @param x the value of x.
     * @return the value
     * @throws Exception
     */
    public double evaluate(Queue<Expression> q, double x) throws Exception;
}

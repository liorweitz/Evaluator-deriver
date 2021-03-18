package expression.functions;

import expression.Expression;
import java.util.Queue;

public interface Function extends Expression {
    /**
     * evaluate the value of the function for specific x.
     * @param x given x value
     * @return function's value
     */
    public double evaluate(double x);

    /**
     * @return inFix notation Queue of the derived function.
     */
    public Queue<Expression> derive();

    /**
     * flag used to tell if in the derivation process this function is in the denominator
     */
    public void setInverseFlag();
}

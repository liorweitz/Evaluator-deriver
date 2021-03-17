package expression.operators;

import expression.Expression;

public interface Operator extends Expression {
    public double evaluate(double op1, double op2) throws Exception;
}

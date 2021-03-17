package expression.functions;

import expression.Expression;

public interface Function extends Expression {
    public double evaluate(double x);
}

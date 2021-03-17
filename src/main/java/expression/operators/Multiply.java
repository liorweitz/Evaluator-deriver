package expression.operators;

public class Multiply implements Operator{
    @Override
    public double evaluate(double op1, double op2) throws Exception {
        return op1*op2;
    }
}

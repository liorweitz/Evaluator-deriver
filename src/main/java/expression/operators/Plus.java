package expression.operators;

public class Plus implements Operator{
    @Override
    public double evaluate(double op1, double op2) throws Exception {
        return op1+op2;
    }
}

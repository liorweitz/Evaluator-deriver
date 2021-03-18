package expression.operators;

public class Power implements Operator{
    @Override
    public double evaluate(double op1, double op2) throws Exception {
        return Math.pow(op1, op2);
    }

    @Override
    public boolean isLeftAssociative() {
        return false;
    }

    @Override
    public boolean isBothering() {
        return true;
    }
}

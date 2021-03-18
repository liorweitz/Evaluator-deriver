package expression.operators;

public class Minus implements Operator{
    @Override
    public double evaluate(double op1, double op2) throws Exception {
        return op1-op2;
    }

    @Override
    public boolean isLeftAssociative() {
        return true;
    }

    @Override
    public boolean isBothering() {
        return false;
    }

    @Override
    public String toString(){
        return "-";
    }
}

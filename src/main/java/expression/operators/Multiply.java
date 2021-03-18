package expression.operators;

public class Multiply implements Operator{
    @Override
    public double evaluate(double op1, double op2) throws Exception {
        return op1*op2;
    }

    @Override
    public boolean isLeftAssociative() {
        return !false;
    }

    @Override
    public boolean isBothering() {
        return true;
    }

    @Override
    public String toString(){
        return "*";
    }
}

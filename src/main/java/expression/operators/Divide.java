package expression.operators;

public class Divide implements Operator{
    @Override
    public double evaluate(double op1, double op2) throws Exception {
        if (op2==0){
            throw new Exception("Division by zero is not allowed!!");
        }
        return op1/op2;
    }

    @Override
    public boolean isLeftAssociative() {
        return true;
    }

    @Override
    public boolean isBothering() {
        return true;
    }

    @Override
    public String toString(){
        return "/";
    }
}

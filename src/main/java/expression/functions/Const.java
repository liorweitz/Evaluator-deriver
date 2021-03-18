package expression.functions;

import expression.Expression;

import java.util.LinkedList;
import java.util.Queue;

public class Const implements Function{
    private double num;
    private boolean inverseFlag;

    public Const(double num){
        this.num=num;
        inverseFlag=false;
    }

    public Const(String s){
        this.num=Double.parseDouble(s);
        inverseFlag=false;
    }

    public double evaluate(double x){
        return num;
    }

    @Override
    public Queue<Expression> derive() {
        Queue<Expression> Q=new LinkedList<>();
        Q.add(new Const(0));
        return Q;
    }

    @Override
    public void setInverseFlag() {
        inverseFlag=true;
    }

    @Override
    public String toString(){
        return String.valueOf(num);
    }
}

package expression.functions;

import expression.Expression;

import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

public class Polynom implements Function {
    private double coef;
    private int pow;
    private boolean inverseFlag;

    public Polynom(double coef, int pow){
       this.coef=coef;
       this.pow=pow;
       inverseFlag=false;
    }

    public Polynom(String s){
        inverseFlag=false;
        int ind=s.indexOf("x");
        if (ind!=0){
            coef=Double.parseDouble(s.substring(0, ind));
        }
        else{
            coef=1;
        }
        ind=s.indexOf("^");
        if (ind!=-1){
            pow=Integer.parseInt(s.substring(ind+1,s.length()));
        }
        else{
            pow=1;
        }

    }

    @Override
    public double evaluate(double x) {
        return (coef*Math.pow(x,pow));
    }

    @Override
    public Queue<Expression> derive() {
        Queue<Expression> Q = new LinkedList<>();

        if (!inverseFlag) {
            if (pow == 1) {
                Q.add(new Const(String.valueOf(coef)));
            } else {
                Q.add(new Polynom(coef * pow, pow - 1));
            }
        }
        else{
            Q.add(new Polynom((-pow)/coef, -pow-1));
        }
        return Q;
    }

    @Override
    public void setInverseFlag() {
        inverseFlag=true;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(coef).append("x");
        if (pow>1){
            sb.append("^").append(pow);
        }
        return sb.toString();
    }
}

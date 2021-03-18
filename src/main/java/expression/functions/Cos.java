package expression.functions;

import expression.Expression;
import expression.operators.Multiply;

import java.lang.Math;
import java.util.LinkedList;
import java.util.Queue;

public class Cos implements Function{
    private double coef;
    private int pow;
    private Polynom poly;
    private boolean inverseFlag;

    public Cos(double coef, int pow, Polynom poly){
        this.coef=coef;
        this.pow=pow;
        this.poly=poly;
        inverseFlag=false;
    }

    public Cos(String s) {
        inverseFlag=false;
        int indOfC = s.indexOf("c");
        if (indOfC != 0) {
            coef = Double.parseDouble(s.substring(0, indOfC));
        }
        else {
            coef=1;
        }
        int indOfoPar = s.indexOf(")");
        poly = new Polynom(s.substring(indOfC + 4, indOfoPar));
        if (indOfoPar < s.length() - 1) {
            pow = Integer.parseInt(s.substring(indOfoPar + 2, s.length()));
        }
        else{
            pow=1;
        }
    }

    public double evaluate(double x){
        return (coef*Math.pow(Math.cos(poly.evaluate(x)),pow));
    }

    @Override
    public Queue<Expression> derive() {
        Queue<Expression> Q=new LinkedList<>();
        Queue<Expression> derived=new LinkedList<>();
        if (!inverseFlag){
            if (pow>1) {
                Q.add(new Cos(coef*pow, pow-1, poly));
                Q.add(new Multiply());
                Q.add(new Sin(-1, 1, poly));
            }
            else {
                Q.add(new Sin(-coef, pow, poly));
            }
            Q.add(new Multiply());
            derived= poly.derive();
            for (Expression exp:derived){ //can make it more readable by iterating over poly.derive()
                Q.add(exp);
            }
        }
        return Q;
    }

    @Override
    public void setInverseFlag() {
        inverseFlag=true;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(coef).append("cos").append("(").append(poly.toString()).append(")");
        if (pow>1){
            sb.append("^").append(pow);
        }
        return sb.toString();
    }
}

package expression.functions;

import expression.Expression;
import expression.operators.Multiply;

import java.util.LinkedList;
import java.util.Queue;

public class Sin implements Function{
    private double coef;
    private int pow;
    private Polynom poly;
    private boolean inverseFlag;

    public Sin(double coef, int pow, Polynom poly){
        this.coef=coef;
        this.pow=pow;
        this.poly=poly;
        inverseFlag=false;
    }

    public Sin(String s){
        inverseFlag=false;
        int indOfS=s.indexOf("s");
        if (indOfS!=0){
            coef=Double.parseDouble(s.substring(0, indOfS));
        }
        else {
            coef=1;
        }
        int indOfoPar=s.indexOf(")");
        poly=new Polynom(s.substring(indOfS+4, indOfoPar));
        if (indOfoPar<s.length()-1){
            pow=Integer.parseInt(s.substring(indOfoPar+2,s.length()));
        }
        else{
            pow=1;
        }
    }

    public double evaluate(double x){
        return (coef*Math.pow(Math.sin(poly.evaluate(x)),pow));
    }

    @Override
    public Queue<Expression> derive() {
        Queue<Expression> Q=new LinkedList<>();
        Queue<Expression> derived=new LinkedList<>();
        if (!inverseFlag){
            if (pow>1) {
                Q.add(new Sin(coef*pow, pow-1, poly));
                Q.add(new Multiply());
                Q.add(new Cos(1, 1, poly));
            }
            else {
                Q.add(new Cos(coef, pow, poly));
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

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(coef).append("sin").append("(").append(poly.toString()).append(")");
        if (pow>1){
            sb.append("^").append(pow);
        }
        return sb.toString();
    }
}

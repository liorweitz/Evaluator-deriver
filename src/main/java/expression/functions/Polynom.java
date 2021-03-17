package expression.functions;

import java.lang.Math;

public class Polynom implements Function {
    private double coef;
    private int pow;

    public Polynom(String s){
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
}

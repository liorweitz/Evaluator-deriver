package expression.functions;

import java.lang.Math;

public class Cos implements Function{
    private double coef;
    private int pow;
    private Polynom poly;

    public Cos(String s) {
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
}

package expression.functions;

public class Sin implements Function{
    private double coef;
    private int pow;
    private Polynom poly;

    public Sin(String s){
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
}

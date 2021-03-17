package expression.functions;

public class Const implements Function{
    private double num;

    public Const(String s){
        this.num=Double.parseDouble(s);
    }

    public double evaluate(double x){
        return num;
    }
}

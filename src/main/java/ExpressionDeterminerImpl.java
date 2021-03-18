import expression.Expression;
import expression.operators.*;
import expression.functions.*;

public class ExpressionDeterminerImpl implements ExpressionDeterminer {

    @Override
    public Expression determine(String s) {
        //operator determiner
        switch(s){
            case "+":
                return new Plus();
            case "-":
                return new Minus();
            case "/":
                return new Divide();
            case "*":
                return new Multiply();
            case "^":
                return new Power();
        }
        //Function determiner

        if (s.contains("sin")){
            return new Sin(s);
        }
        else if (s.contains("cos")){
            return new Cos(s);
        }
        else if (s.contains("x")){
            return new Polynom(s);
        }
        //function is const
        else{
            return new Const(s);
        }
    }
}

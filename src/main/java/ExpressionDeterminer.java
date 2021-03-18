import expression.Expression;
import expression.functions.Function;

public interface ExpressionDeterminer {
    /**
     * determines the appropriate class type of the string expression, instantiate the class object
     * and returns it.
     * @param s the string expression symbolizing the function/operator.
     * @return Expression object.
     */
    public Expression determine(String s);
}

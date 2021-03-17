import expression.Expression;
import expression.functions.Function;
import expression.operators.Operator;

import java.util.Queue;
import java.util.Stack;

public class EvaluatorImpl implements Evaluator {

    public double evaluate(Queue<Expression> Q, double x) throws Exception {
        Stack<Double> s=new Stack<>();
        for (Expression exp:Q){
            if (Function.class.isAssignableFrom(exp.getClass())){
                s.push(((Function)exp).evaluate(x));
            }
            else {
                double op1=s.pop();
                double op2=s.pop();
                s.push(((Operator)exp).evaluate(op2, op1));
            }
        }
        return s.pop();
    }
}

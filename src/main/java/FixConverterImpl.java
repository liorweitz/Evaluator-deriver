import expression.Expression;
import expression.operators.Operator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FixConverterImpl implements FixConverter{
    private comparator

    @Override
    public Queue<Expression> makePostFix(Queue<Expression> inFix) { //makePostFix -> inToFix
        Queue<Expression> postFix=new LinkedList<>();
        Stack<Expression> operators=new Stack<>();
        for (Expression exp:inFix){
            if (!Operator.class.isAssignableFrom(exp.getClass())){
                postFix.add(exp);
            }
            else{
                while(!operators.isEmpty() && (comparator.compare(operators.peek(), exp)>0 |
                        (comparator.compare(operators.peek(), exp)==0 & isLeftAssociative(exp)))){
                    postFix.add(operators.pop());
                }
            }
        }
    }

    @Override
    public Queue<Expression> makeInFix(Queue <Expression> Q) {
        return null;
    }
}

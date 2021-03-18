import expression.Expression;
import expression.operators.Operator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FixConverterImpl implements FixConverter{
    private Comparator comparator;

    public FixConverterImpl(Comparator comp){
        comparator=comp;
    }
    @Override
    public Queue<Expression> makePostFix(Queue<Expression> inFix) { //makePostFix -> inToFix
        Queue<Expression> postFix=new LinkedList<>();
        Stack<Expression> operators=new Stack<>();
        for (Expression exp:inFix){
            if (!Operator.class.isAssignableFrom(exp.getClass())){
                postFix.add(exp);
            }
            else{
                while(!operators.isEmpty() && (comparator.compare(operators.peek().toString(), exp.toString())>0 |
                        (comparator.compare(operators.peek().toString(), exp.toString())==0 & ((Operator)(exp)).isLeftAssociative()))){
                    postFix.add(operators.pop());
                }
                operators.add(exp);
            }
        }
        while (!operators.isEmpty()){
            postFix.add(operators.pop());
        }
        return postFix;
    }

    @Override
    public Queue<Expression> makeInFix(Queue <Expression> Q) {
        return null;
    }
}

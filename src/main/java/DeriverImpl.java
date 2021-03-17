import expression.Expression;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeriverImpl implements Deriver{
    private Stack<Expression> s;
    private Queue<Expression> output;

    public DeriverImpl(){
        s=new Stack<>();
        output=new LinkedList<>();
    }

    @Override
    public Queue<Expression> derive(Queue<Expression> input) {
        Stack<Expression> s;
        for ()
    }
}

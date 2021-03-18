import expression.Expression;
import expression.functions.Function;
import expression.operators.Divide;
import expression.operators.Multiply;
import expression.operators.Operator;
import expression.operators.Plus;

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
        Queue<Expression> output=new LinkedList<>();
        Queue<Function> Q=new LinkedList<>();

        while (!input.isEmpty()){
            Expression exp=input.poll();
            if (Operator.class.isAssignableFrom(exp.getClass())){
//                does bother to derivation
                if (Multiply.class.isAssignableFrom(exp.getClass())){
                    exp=input.poll();
                    Q.add((Function) exp);
                }
                else if (Divide.class.isAssignableFrom(exp.getClass())){
                    exp=input.poll();
                    ((Function)exp).setInverseFlag();
                    Q.add((Function) exp);
                }
                //doesnt bother
                else if (!((Operator)exp).isBothering()){
                    subDerive(Q, output);
                    output.add(exp);
                }
            }
            else{
                Q.add((Function) exp);
            }
        }
        if (!Q.isEmpty()){
            subDerive(Q,output);
        }
        return output;
    }

    /**
     * Helper function to derive sections of multiplication and divisions of the original equation.
     * @param q
     * @param output
     */
    private void subDerive(Queue<Function> q, Queue<Expression> output) {
        Queue<Expression> derived=new LinkedList<>();
        for (int cycle=0; cycle<q.size();cycle++){
//            output.add(new Plus());
            int i=0;
            for (Function func:q){
                if (i == cycle) {
                    derived = func.derive();
                    while (!derived.isEmpty()) {
                        output.add(derived.poll());
                    }
                }
                else{
                    output.add(func);
                }
                if (0<=i & i<q.size()-1) {
                    output.add(new Multiply());
                }
                i++;
            }
            if (cycle<q.size()-1){
                output.add(new Plus());
            }
        }
        q.clear();
    }
}

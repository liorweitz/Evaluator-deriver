import expression.Expression;
import expression.operators.Operator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionTree {
    private String inputString;
    private ExpressionNode root;
    private Queue<Expression> inFix;
    private Queue<Expression> postFix;
    private Comparator comparator;
    private ExpressionDeterminer expDet;
    private FixConverter fixConv;

    public ExpressionTree(String s, Comparator comparator, ExpressionDeterminer expDet, FixConverter fixConv){
        inputString=null;
        this.comparator=comparator;
        root=null;
        inFix=new LinkedList<>();
        postFix=new LinkedList<>();
        this.expDet=expDet;
        inputString=s;
    }

    public void initialize(){
        insertToInFix(inputString);
        postFix=fixConv.makePostFix(inFix);
    }

    private void insertToInFix(String s) {
        String [] tokens=s.split(" ");
        for (String token:tokens){
            inFix.add(expDet.determine(token));
        }
    }

    private void makePostFix(String s) {
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


        Stack<String> operators=new Stack<String>();
        for (String token:tokens){
            if (!isOperator(token)){
                postFix.add(expDet.determine(token));
            }
            else {
                while (!operators.empty() &&
                        (comparator.compare(operators.peek(), token)>0 |
                                (comparator.compare(operators.peek(), token)==0 & !token.equals('^')))){
                    postFix.add(expDet.determine(operators.pop()));// determine->getFunc
                }
                operators.push(token);
            }
        }
        while (!operators.empty()){
            postFix.add(expDet.determine(operators.pop()));
        }
        int i=3;
    }

    private boolean isOperator(String token) {
        if (token.equals("+") | token.equals("-") | token.equals("*") | token.equals("/") | token.equals("^")){
            return true;
        }
        return false;
    }

    public void evaluate(int x) throws Exception {
        Evaluator ev=new EvaluatorImpl();
        System.out.println(ev.evaluate(postFix,5));
    }
}

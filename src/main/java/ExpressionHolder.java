import expression.Expression;
import expression.operators.Operator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionHolder {
    private String expressionString;
    private Queue<Expression> inFix;
    private Queue<Expression> postFix;
    private ExpressionDeterminer expDet;
    private FixConverter fixConv;
    private Evaluator evaluator;
    private Deriver deriver;

    public ExpressionHolder(String s, Comparator comparator, ExpressionDeterminer expDet, Evaluator ev, DeriverImpl deriver){
        expressionString=s;
        inFix=new LinkedList<>();
        postFix=new LinkedList<>();
        this.expDet=expDet;
        this.fixConv=new FixConverterImpl(comparator);
        this.evaluator=ev;
        this.deriver=deriver;
    }

    public void initialize(){
        insertToInFix();
    }

    private void insertToInFix() {
        String[] tokens = expressionString.split(" ");
        for (String token : tokens) {
            inFix.add(expDet.determine(token));
        }
    }

    private void extractFromInFix(){
        StringBuilder sb=new StringBuilder();
        for (Expression exp:inFix){
            sb.append(exp.toString());
            sb.append(" ");
        }
        expressionString=sb.toString();
    }

    public void evaluate(int x) throws Exception {
        postFix=fixConv.makePostFix(inFix);
        System.out.println(evaluator.evaluate(postFix,x));
    }

    public void derive(){
        inFix=deriver.derive(inFix);
        postFix=fixConv.makePostFix(inFix);
        extractFromInFix();
    }

    public String toString(){
        return expressionString;
    }


}

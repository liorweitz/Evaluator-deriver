import expression.Expression;

import java.util.Queue;

/**
 * Simple Deriver that works for maximum instances of one chain rule and one multiplication/division derivation.
 */
public interface Deriver {
    /**
     * This method receives a queue consisting of the mathemathicall expression in infix notation
     * and derive it using the rules.
     * @param Q infix notation equation.
     * @return Queue containing the derived function in inFix.
     */
    public Queue<Expression> derive(Queue<Expression> Q);
}

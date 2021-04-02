import expression.Expression;

import java.util.Queue;

/**
 * Simple Deriver that works for positive powers. includes support for future negative power derivation.
 */
public interface Deriver {
    /**
     * This method receives a queue consisting of the mathematical expression in infix notation
     * and derive it using the rules.
     * @param Q infix notation equation.
     * @return Queue containing the derived function in inFix.
     */
    public Queue<Expression> derive(Queue<Expression> Q);
}

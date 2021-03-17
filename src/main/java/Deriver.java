import expression.Expression;

import java.util.Queue;

/**
 * Simple Deriver that works for maximum instances of one chain rule and one multiplication/division derivation.
 */
public interface Deriver {
    public Queue<Expression> derive(Queue<Expression> Q);
}

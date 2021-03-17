import expression.Expression;

import java.util.Queue;

public interface FixConverter {
    public Queue<Expression> makePostFix(Queue<Expression> Q);
    public Queue<Expression> makeInFix(Queue<Expression> Q);
}

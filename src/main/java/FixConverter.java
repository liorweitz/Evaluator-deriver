import expression.Expression;

import java.util.Queue;

public interface FixConverter {
    /**
     * @param Q inFix Queue
     * @return postFix Queue
     */
    public Queue<Expression> makePostFix(Queue<Expression> Q);

    /**
     * @param Q postFix queue
     * @return inFix queue
     */
    public Queue<Expression> makeInFix(Queue<Expression> Q);
}

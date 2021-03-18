package expression.operators;

import expression.Expression;

public interface Operator extends Expression {
    /**
     * @param op1 operand 1
     * @param op2 operand 2
     * @return operation value for operands
     * @throws Exception for division by zero
     */
    public double evaluate(double op1, double op2) throws Exception;

    /**
     * @return true if operator is left associative or false otherwise
     */
    public boolean isLeftAssociative();

    /**
     * @return true if the operator cause more complication in the derivation.
     * such as multiplication or division.
     */
    public boolean isBothering();
}

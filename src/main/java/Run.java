public class Run {
    /**
     * Input Assumptions:
     * 1) Between expression there must be space.
     * 2) complete expression have no spaces between symbols. like so: 3x^2, sin(3x).
     * 3) in a complete expression there must not be const of the type of 2/3 or 2*3. only const of type double.
     * 4) The inner function in a composition must be inside parentheses.
     * 5) Similarily to the 3rd assumption, it is not allowed to divide or multiply by a complete expression of
     * const, like so: 3x^2 / 3.
     * @param args
     * @throws Exception in case of division by zero.
     */
    public static void main(String[] args) throws Exception {
        String s="3x^2 + sin(3x^20)^20";
        ExpressionHolder exp=new ExpressionHolder(s, new PrecComparator(), new ExpressionDeterminerImpl(), new EvaluatorImpl(), new DeriverImpl());
        exp.initialize();

        exp.evaluate(3);
        exp.derive();
        System.out.println(exp);
        exp.evaluate(2);

    }
}

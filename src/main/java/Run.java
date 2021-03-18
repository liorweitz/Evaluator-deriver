public class Run {
    /**
     * The input must have the following rule: between expression there must be space.
     * every expression is without spaces and the functions are with parantheses and without
     * multipication operators. for example: 3x^2 + 6 + 3sin(2x^2) In addition it is not permitted
     * to add multiplication or division by const to complete function expression (no spaces).
     * for example: the next expression will not derive well: 3x^2 + 6 + 3sin(2x^2) / 3.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String s="2x^2 / 3";
        ExpressionHolder exp=new ExpressionHolder(s, new PrecComparator(), new ExpressionDeterminerImpl(), new EvaluatorImpl(), new DeriverImpl());
        exp.initialize();

        exp.evaluate(3);
        exp.derive();
        System.out.println(exp);
        exp.evaluate(2);

    }
}

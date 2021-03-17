public class Run {
    // the expression the system receives is the running argument.
    // The Assumption is, that the expression is legal and includes spaces between the characters.
    //
    public static void main(String[] args) throws Exception {
        PrecComparator comparator =new PrecComparator();
        String s="1 / 3x^2 - 5 + sin(x)";
        ExpressionTree exp=new ExpressionTree(s, comparator, new ExpressionDeterminerImpl(), new FixConverterImpl());
        exp.initialize();
        exp.evaluate(5);
    }
}

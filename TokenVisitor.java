public interface TokenVisitor {
    public int visit(Variable v);
    public int visit(Nullary x);
    public int visit(Unary u);
    public int visit(Binary b);
}

public class Binary implements Token{
    private final BinaryOperator bop;

    Binary(BinaryOperator bop) { this.bop = bop; }

    public Boolean execute(Boolean a, Boolean b){ return bop.execute(a, b); }

    public int accept(TokenVisitor t){
        return t.visit(this);
    }

    public String toString() { return bop.toString(); }

    // binary operators (strategy)
    public static class And implements BinaryOperator{ //n
        @Override public Boolean execute(Boolean a, Boolean b) { return a && b; }
        public String toString() { return "∧"; }
    }

    public static class Nand implements BinaryOperator{ //!n
        @Override public Boolean execute(Boolean a, Boolean b) { return !(a && b); }
        public String toString() { return "⊼"; }
    }

    public static class Or implements BinaryOperator { //v
        @Override public Boolean execute(Boolean a, Boolean b) { return a || b; }
        public String toString() { return "∨"; }
    }

    public static class Nor implements BinaryOperator { //!v
        @Override public Boolean execute(Boolean a, Boolean b) { return !(a || b); }
        public String toString() { return "⊽"; }
    }

    public static class Xor implements BinaryOperator { //xv
        @Override public Boolean execute(Boolean a, Boolean b) { return a ^ b; }
        public String toString() { return "⊻"; }
    }

    public static class Implies implements BinaryOperator { //=>
        @Override public Boolean execute(Boolean a, Boolean b) { return a || (!b); }
        public String toString() { return "⇒"; }
    }

    public static class Bicond implements BinaryOperator { //<>
        @Override public Boolean execute(Boolean a, Boolean b) { return a == b; }
        public String toString() { return "⟺"; }
    }
}

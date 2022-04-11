public class Unary implements Token{
    private final UnaryOperator uop;

    Unary(UnaryOperator uop) { this.uop = uop; }

    public Boolean execute(Boolean val){ return uop.execute(val); }

    public int accept(TokenVisitor t){
        return t.visit(this);
    }

    public String toString() { return uop.toString(); }

    // unary operators (strategy pattern) (can be static as they dont depend on an instance of our token)
    public static class Not implements UnaryOperator { //!, ¬
        @Override public Boolean execute(Boolean val){ return !val; }
        public String toString(){ return "¬"; }
    }
    public static class Nop implements UnaryOperator { //#
        @Override public Boolean execute(Boolean val){ return val; }
        public String toString(){ return "#"; }
    } //just for fun
}

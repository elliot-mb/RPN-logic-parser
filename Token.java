public interface Token {
    public int accept(TokenVisitor t); //either the tokenizer or the stack are visitors

    public String toString();

    public interface UnaryOperator{
        public Boolean execute(Boolean val);
        public String toString();
    }

    public interface BinaryOperator{
        public Boolean execute(Boolean a, Boolean b);
        public String toString();
    }
}

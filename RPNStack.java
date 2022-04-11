public class RPNStack implements TokenVisitor{
    private final Boolean[] stack;
    private int size;
    private final int limit = 100; //maximum stack size

    RPNStack(){
        this.size = 0;
        this.stack = new Boolean[limit];
    }

    RPNStack(Boolean[] stack){ //copy constructor
        this.size = limit;
        this.stack = stack;
    }

    public void push(Boolean val){
        assert(size + 1 <= limit);
        stack[size] = val;
        size++;
    }

    public Boolean peek() {
        assert(size > 0);
        return stack[size - 1];
    }

    public Boolean pop(){
        assert(size > 0);
        Boolean result = stack[size - 1];
        size--;
        return result;
    }

    public void empty(){
        this.size = 0;
    }

    public Boolean evaulate(Token[] statement){ //assume statment is fully defined (no null variables) and well-formed
        for(Token t : statement) {
            t.accept(this);
        }
        return pop();
    }

    //visitor pattern to define behaviour for different symbol types
    public int visit(Variable v) {
        push(v.execute());
        return size;
    }

    public int visit(Nullary x){
        push(x.execute());
        return size;
    }

    public int visit(Unary u) {
        push(u.execute(pop()));
        return size;
    }

    public int visit(Binary b){
        push(b.execute(pop(), pop()));
        return size;
    }
}

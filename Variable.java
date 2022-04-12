public class Variable implements Token{
    private Nullary n; //mutable Nullary (its value) class that changes to make truth tables
    private final String name;

    Variable(String name){
        this.name = name;
    }

    Variable(String name, Boolean val) {
        this.name = name;
        this.n = new Nullary(val);
    }

    public Boolean execute() {
        //assert (n != null);
        return n.execute();
    }

    public void setVal(Boolean val) { n = new Nullary(val); }

    public int accept(TokenVisitor t){
        return t.visit(this);
    }

    public String toString() {
        if(n != null) return n.toString();
        else return name;
    }
}

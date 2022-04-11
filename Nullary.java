public class Nullary implements Token{
    private final Boolean val;

    Nullary(Boolean val){ this.val = val; }

    public Boolean execute(){ return val; }

    public int accept(TokenVisitor t){
        return t.visit(this);
    }

    public String toString(){
        return val ? "T" : "F";
    }
}

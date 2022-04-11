import java.util.*;

import static java.util.Map.entry;

public class Tokenizer { //must visit tokens to detemine statement validity as a whole
    private static final Map<String, Token> strToTkn = Map.ofEntries(
            entry("T", new Nullary(true)),
            entry("1", new Nullary(true)),
            entry("F", new Nullary(false)),
            entry("0", new Nullary(false)),
            entry("!", new Unary(new Unary.Not())),
            entry("¬", new Unary(new Unary.Not())),
            entry("#", new Unary(new Unary.Nop())),
            entry("n", new Binary(new Binary.And())),
            entry("!n", new Binary(new Binary.Nand())),
            entry("v", new Binary(new Binary.Or())),
            entry("!v", new Binary(new Binary.Nor())),
            entry("xv", new Binary(new Binary.Xor())),
            entry("=>", new Binary(new Binary.Implies())),
            entry("<>", new Binary(new Binary.Bicond()))
    );
    private Token[] tokens;
    private Variable[] variables;
    private boolean wellFormed;

    Tokenizer(String input){
        parse(input);
    }

    public Token[] getTokens(){ return tokens; }
    public Variable[] getVariables(){ return variables; }
    public boolean getWellFormed(){ return wellFormed; }

    private boolean isWellFormed(){ //safety
        TokenVisitor changeVisitor = new TokenVisitor(){ //returns the change in height
            public int visit(Variable v) { return 1; }
            public int visit(Nullary x){ return 1; }
            public int visit(Unary u){ return 0; }
            public int visit(Binary b){ return -1; }
        };
        int height = 0;
        for(Token token : tokens) {
            height += token.accept(changeVisitor);
            if(height < 1 || height > 100) { return false; }
        }
        return height == 1;
    }
//
//    private Variable[] getVariables(){ //for truth table generation
//        TokenVisitor variableVisitor = new TokenVisitor() {
//            public int visit(Variable v) { return 1; }
//            public int visit(Nullary x) { return 0; }
//            public int visit(Unary u) { return 0; }
//            public int visit(Binary b) { return 0; }
//        };
//        List<Variable> variables = new ArrayList<Variable>();
//        for(Token token : tokens){
//            if(token.accept(variableVisitor) == 1) { variables.add((Variable) token); }
//        }
//        Variable[] result = new Variable[variables.size()];
//        variables.toArray(result);
//        return result;
//    }

    private void parse(String s){
        String[] parts = s.split("[\s]+");
        Token[] tokens = new Token[parts.length];
        Map<String, Variable> variables = new HashMap<String, Variable>();
        for(int i = 0; i < tokens.length; i++){
            String part = parts[i];
            if(strToTkn.containsKey(part)) tokens[i] = strToTkn.get(part);
            else {
                if(!variables.containsKey(part)) variables.put(part, new Variable(part));
                tokens[i] = variables.get(part); //if its a user-defined variable name (e.g. A, b, var, iLoveNewYork)
            }
        }
        this.tokens = tokens;
        //System.out.println(Arrays.toString(tokens));
        //System.out.println(variables);
        this.variables = variables.values().toArray(new Variable[0]);
        this.wellFormed = isWellFormed();
    }

}

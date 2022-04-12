import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
/*
directions for usage of this logic parser

all expressions must be entered in reverse polish notation
any expressions with variables will have a truth table generated for it

variables:
    {A, a, B, b, ..., Z, z} (expected set of variables)
nullary operators:
    F, f, 0 (false)
    T, t, 1 (true)
unary operators:
    ¬ ! (not)
    # (no-op)
binary operators:
    n (and), !n (nand)
    v (or), !v (nor), xv (xor)
    => (implies), <> (biconditional)
 */
    public static void main(String[] args){
        RPNStack stack = new RPNStack();

        while(true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String expression = "";
            System.out.println("Enter a logical expression in Reverse Polish Notation");
            try {
                expression = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            stack.empty();
            Tokenizer parser = new Tokenizer(expression);
            Token[] tokens = parser.getTokens();
            Variable[] variables = parser.getVariables();

            if(parser.getWellFormed()) {
                if(variables.length == 0) { System.out.println((stack.evaulate(tokens) ? "T" : "F")); }
                else {
                    // truth table business
                    String paddingLeft = ""; String paddingRight = "";
                    for(int k = 0; k < Arrays.toString(variables).length() - (variables.length * 3); k++){
                        if(k % 2 == 0) { paddingRight += " "; }
                        else { paddingLeft += " "; }
                    }

                    String resultPadding = "";
                    for(int l = 0; l < Math.ceil((double) Arrays.toString(tokens).length() / 2) - 1; l++) {
                        resultPadding += " ";
                    }

                    System.out.print(Arrays.toString(variables));
                    System.out.print(" │ " + Arrays.toString(tokens));
                    System.out.println();

                    for (int i = 0; i < Math.pow(2, variables.length); i++) {
                        String combination = Integer.toBinaryString((int) (Math.pow(2, variables.length) + i)).substring(1);
                        for (int j = 0; j < variables.length; j++) {
                            variables[j].setVal(combination.charAt(j) == '1');
                        }
                        System.out.print(paddingLeft + Arrays.toString(variables) + paddingRight);
                        //System.out.print(" | " + Arrays.toString(tokens));
                        System.out.print(" │ " + resultPadding  + (stack.evaulate(tokens) ? "T" : "F"));
                        System.out.println();
                        stack.empty();
                    }
                }
            } else { System.out.println("Your expression is not well-formed! Couldn't parse"); }
        }
    }
}
